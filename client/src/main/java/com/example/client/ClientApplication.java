package com.example.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.opentelemetry.api.logs.Severity;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.contrib.sampler.RuleBasedRoutingSampler;
import io.opentelemetry.sdk.autoconfigure.spi.AutoConfigurationCustomizerProvider;
import io.opentelemetry.semconv.UrlAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootApplication
public class ClientApplication {

	private static final Logger log = LoggerFactory.getLogger(ClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	// tag::rest-template[]
	// IMPORTANT! To instrument RestTemplate you must inject the RestTemplateBuilder
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	// end::rest-template[]

	@Bean
	public AutoConfigurationCustomizerProvider otelCustomizer() {
		return p -> {
			p.addLogRecordProcessorCustomizer((logRecordProcessor, configProperties) -> (context, logRecord) -> {
				if (logRecord.toLogRecordData().getSeverity().getSeverityNumber() >= Severity.INFO.getSeverityNumber()) {
					logRecordProcessor.onEmit(context, logRecord);
				}
			});
			p.addSamplerCustomizer(
					(fallback, config) ->
							RuleBasedRoutingSampler.builder(SpanKind.SERVER, fallback)
									.drop(UrlAttributes.URL_PATH, "^/actuator")
									.build());
		};
	}

	// tag::runner[]
	@Bean
	CommandLineRunner myCommandLineRunner(ObservationRegistry registry, RestTemplate restTemplate, ObjectMapper objectMapper) {
		Random highCardinalityValues = new Random(); // Simulates potentially large number of values
		List<String> lowCardinalityValues = Arrays.asList("userType1", "userType2", "userType3"); // Simulates low number of values
		Faker faker = new Faker();
		return args -> {
			// let's simulate endless traffic
			String requestId = null;
			AtomicBoolean failedLastRequest = new AtomicBoolean(false);
			while (true) {
				if (requestId == null || failedLastRequest.getAndSet(false) || highCardinalityValues.nextInt(10, 50) % 2 == 0) {
					requestId = UUID.randomUUID().toString();
					log.info("Generated new requestId: {}", requestId);
				}
				Map<String, String> request = new HashMap<>();
				String fullName = faker.name().fullName();
				request.put("name", fullName);
				request.put("requestId", requestId);
				String payload = objectMapper.writeValueAsString(request);
				String highCardinalityUserId = String.valueOf(highCardinalityValues.nextLong(100_000));
				// Example of using the Observability API manually
				// <my.observation> is a "technical" name that does not depend on the context. It will be used to name e.g. Metrics
				Observation.createNotStarted("my.observation", registry)
						// Low cardinality means that the number of potential values won't be big. Low cardinality entries will end up in e.g. Metrics
						.lowCardinalityKeyValue("userType", randomUserTypePicker(lowCardinalityValues))
						// High cardinality means that the number of potential values can be large. High cardinality entries will end up in e.g. Spans
						.highCardinalityKeyValue("userId", highCardinalityUserId)
						// <command-line-runner> is a "contextual" name that gives more details within the provided context. It will be used to name e.g. Spans
						.contextualName("command-line-runner")
						// The following lambda will be executed with an observation scope (e.g. all the MDC entries will be populated with tracing information). Also the observation will be started, stopped and if an error occurred it will be recorded on the observation
						.observe(() -> {
							log.info("Will send a request to the server with payload: {}", payload); // Since we're in an observation scope - this log line will contain tracing MDC entries ...
							HttpHeaders httpHeaders = new HttpHeaders();
							httpHeaders.setContentType(MediaType.APPLICATION_JSON);
							HttpEntity<String> httpEntity = new HttpEntity<>(payload, httpHeaders);
							try {
								ResponseEntity<String> response = restTemplate.exchange("http://localhost:7654/user", HttpMethod.POST, httpEntity, String.class); // Boot's RestTemplate instrumentation creates a child span here
								log.info("Got response [{}] - [{}]", response.getStatusCode(), response.getBody()); // ... so will this line
								if (response.getStatusCode().isError()) {
									failedLastRequest.set(true);
								}
							} catch (Exception e) {
								log.warn("Failed to request server", e);
								failedLastRequest.set(true);
							}
						});
				Thread.sleep(highCardinalityValues.nextLong(500));
			}

		};
	}
	// end::runner[]

	Random randomUserTypePicker = new Random();

	private String randomUserTypePicker(List<String> lowNumberOfValues) {
		return lowNumberOfValues.get(randomUserTypePicker.nextInt(2));
	}
}

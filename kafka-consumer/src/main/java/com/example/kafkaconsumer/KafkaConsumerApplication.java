package com.example.kafkaconsumer;

import com.example.schema.avro.Person;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Random;

@SpringBootApplication
public class KafkaConsumerApplication {
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
    }


    @Bean
    MyKafkaListener myKafkaListener(Tracer tracer, ObservationRegistry observationRegistry) {
        return new MyKafkaListener(tracer, observationRegistry);
    }

}

class MyKafkaListener {

    private static final Logger log = LoggerFactory.getLogger(MyKafkaListener.class);

    private final Tracer tracer;

    private final ObservationRegistry observationRegistry;

    MyKafkaListener(Tracer tracer, ObservationRegistry observationRegistry) {
        this.tracer = tracer;
        this.observationRegistry = observationRegistry;
    }

    @KafkaListener(topics = "${TOPIC_NAME:person-topic}")
    void onMessage(Person person, @Headers MessageHeaders headers) {
        Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
            log.info("Processing message: {}", person);
            log.info("### -> Receiving headers: {}", headers);
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("<ACCEPTANCE_TEST> <TRACE:{}> Hello from consumer", this.tracer.currentSpan().context().traceId());
            log.info("Processed completed!");
        });
    }

}
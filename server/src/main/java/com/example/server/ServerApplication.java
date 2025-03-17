package com.example.server;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.observation.annotation.Observed;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Random;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

// tag::controller[]
@RestController
class MyController {

	private static final Logger log = LoggerFactory.getLogger(MyController.class);
	private final MyUserService myUserService;

	MyController(MyUserService myUserService) {
		this.myUserService = myUserService;
	}

	@PostMapping("/user")
	ResponseEntity<PersonResponseDto> save(@RequestBody @Valid PersonDto person) {
		log.info("Got a request");
		PersonResponseDto responseDto = myUserService.save(person);
		if (responseDto.status() == Status.FAILED) {
			return ResponseEntity.badRequest().body(responseDto);
		}
		return ResponseEntity.ok(responseDto);
	}
}
// end::controller[]

// tag::service[]
@Service
class MyUserService {

	private static final Logger log = LoggerFactory.getLogger(MyUserService.class);

	private final Random random = new Random();
	private final PersonRepository personRepository;
	private final KafkaTemplate<String, Object> kafkaTemplate;

    MyUserService(PersonRepository personRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.personRepository = personRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    // Example of using an annotation to observe methods
	// <user.name> will be used as a metric name
	// <getting-user-name> will be used as a span  name
	// <userType=userType2> will be set as a tag for both metric & span
	@Observed(name = "user.name",
			contextualName = "getting-user-name",
			lowCardinalityKeyValues = {"userType", "userType2"})
	PersonResponseDto save(PersonDto person) {
		try {
			if (personRepository.existsById(person.requestId(), random.nextInt(1, 10))) {
				throw new IllegalStateException("Person already exists");
			}
			log.info("Saving person <{}>", person);
			personRepository.save(mapToPerson(person));
			PersonResponseDto personResponseDto = new PersonResponseDto(Status.CREATED, person.name(), person.requestId());
			sendKafka(personResponseDto);
			return personResponseDto;
		} catch (Exception e) {
			log.error("failed to create person", e);
			PersonResponseDto personResponseDto = new PersonResponseDto(Status.FAILED, person.name(), person.requestId());
			sendKafka(personResponseDto);
			return personResponseDto;
		}
	}

	private void sendKafka(PersonResponseDto response) {
		com.example.schema.avro.Person person = new com.example.schema.avro.Person();
		person.setRequestId(response.requestId());
		person.setName(response.name());
		person.setStatus(response.status().name());
		person.setCreatedAt(Instant.now());
		kafkaTemplate.send(MessageBuilder.withPayload(person).build());
	}

	private Person mapToPerson(PersonDto personDto) {
		return new Person(personDto.requestId(), personDto.name());
	}
}
// end::service[]

// tag::handler[]
// Example of plugging in a custom handler that in this case will print a statement before and after all observations take place
@Component
class MyHandler implements ObservationHandler<Observation.Context> {

	private static final Logger log = LoggerFactory.getLogger(MyHandler.class);

	@Override
	public void onStart(Observation.Context context) {
		log.info("Before running the observation for context [{}], userType [{}]", context.getName(), getUserTypeFromContext(context));
	}

	@Override
	public void onStop(Observation.Context context) {
		log.info("After running the observation for context [{}], userType [{}]", context.getName(), getUserTypeFromContext(context));
	}

	@Override
	public boolean supportsContext(Observation.Context context) {
		return true;
	}

	private String getUserTypeFromContext(Observation.Context context) {
		return StreamSupport.stream(context.getLowCardinalityKeyValues().spliterator(), false)
				.filter(keyValue -> "userType".equals(keyValue.getKey()))
				.map(KeyValue::getValue)
				.findFirst()
				.orElse("UNKNOWN");
	}
}
// end::handler[]

interface PersonRepository extends CrudRepository<Person, String> {
	@Query(value = "CALL existsPersonById(:id, :time);", nativeQuery = true)
	boolean existsById(@Param("id") String id, @Param("time") Integer time);
}

enum Status {
	CREATED,
	FAILED
}

record PersonResponseDto(Status status, String name, String requestId) {
}

record PersonDto (
		@NotBlank
		String requestId,
		@NotBlank
		String name) {
}

@Entity
@NamedStoredProcedureQuery(name = "Person.existsPersonById",
		procedureName = "existsPersonById", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "sleep_time", type = Integer.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "exists_by", type = Integer.class)})
class Person {
	@Id
	@NotBlank
	private String id;

	@NotBlank
	private String name;

	public Person() {
	}

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
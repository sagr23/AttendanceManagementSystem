package com.attendence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableKafka
@EnableKafkaStreams
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpa1Application.class, args);
	}


}

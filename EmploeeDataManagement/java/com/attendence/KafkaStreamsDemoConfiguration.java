package com.attendence;

import org.apache.kafka.streams.StreamsConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaStreamsDemoConfiguration {
	
	@Bean
	public StreamsConfig streamConfig(KafkaProperties properties) {
		return new StreamsConfig(properties.buildStreamsProperties());
		
	}

    
}
package com.attendence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplte;
	
	public void sendCheckInToTopic(String message) {
		
		kafkaTemplte.send("checkinmsg", message);
	}
	
	
	public void sendCheckOutToTopic(String message) {
		
		kafkaTemplte.send("checkoutmsg", message);
	}
}

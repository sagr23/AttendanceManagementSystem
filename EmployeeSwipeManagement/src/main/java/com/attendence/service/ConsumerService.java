package com.attendence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.attendence.dao.LoggingDao;

@Service
public class ConsumerService {

	@Autowired
	LoggingDao loggingDao;
	
	@KafkaListener(topics = "checkinmsg", groupId = "codeDecodeGroup")
	public void listenToTopic1(String recivedMessage) {
		
		System.out.println("recivedMessage :" + recivedMessage);
		loggingDao.saveCheckInData(recivedMessage);
		
	}
	@KafkaListener(topics = "checkoutmsg", groupId = "codeDecodeGroup")
	public void listenToTopic2(String recivedMessage) {
		
		System.out.println("recivedMessage :" + recivedMessage);
		loggingDao.saveCheckOutData(recivedMessage);
		
	}	
	
}

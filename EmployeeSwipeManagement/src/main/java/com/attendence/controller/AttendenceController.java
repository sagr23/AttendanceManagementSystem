package com.attendence.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendence.service.ProducerService;

@RestController
public class AttendenceController {

	@Autowired
	ProducerService producerService;

	@GetMapping("/checkInTime")
	public void getCheckInFromEmployee(@RequestParam("empId") int empId) {

		/*
		 * CheckInData checkinData = new CheckInData();
		 * checkinData.setCheckinDateTime(LocalDateTime.now().toString());
		 * checkinData.setEmployeeId(empId);
		 */
		
		String checkinData = empId+"##"+LocalDateTime.now().toString(); 
		producerService.sendCheckInToTopic(checkinData);

	}

	@GetMapping("/checkOutTime")
	public void getCheckOutFromEmployee(@RequestParam("empId") int empId) {

		/*
		 * CheckOutData checkoutData = new CheckOutData();
		 * checkoutData.setCheckoutDateTime(LocalDateTime.now().toString());
		 * checkoutData.setEmployeeId(empId);
		 */
		
		String checkoutData = empId+"##"+LocalDateTime.now().toString();
		producerService.sendCheckOutToTopic(checkoutData);

	}
	
	
	
}

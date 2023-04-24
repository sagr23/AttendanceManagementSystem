package com.attendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendence.DataObject.EmployeeData;
import com.attendence.service.EmployeeRecordService;

@RestController
public class EmployeeRecordController {
	
	@Autowired
	EmployeeRecordService employeeRecordService;
	
	@Autowired
	EmployeeData employeeData;
	
	@GetMapping("/getEmployeeDetail")
	public ResponseEntity<EmployeeData> totalHoursPresent(@RequestParam int id) {
	
		EmployeeData employeeData = employeeRecordService.getTotalHours(id);
		
		return new ResponseEntity<>(
			      employeeData, 
			      HttpStatus.OK);
	}

}

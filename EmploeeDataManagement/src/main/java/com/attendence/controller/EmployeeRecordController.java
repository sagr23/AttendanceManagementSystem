package com.attendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendence.entities.EmployeeData;
import com.attendence.repository.EmployeeDataRepository;
import com.attendence.service.EmployeeRecordService;

@RestController
public class EmployeeRecordController {
	
	@Autowired
	EmployeeRecordService employeeRecordService;
	
	@Autowired
	EmployeeData employeeData;
	
	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	@GetMapping("/totalHoursInOffice")
	public String totalHoursPresent(@RequestParam int id) {
	
		int totalHours =0;
		 employeeRecordService.data(id);
		String status = null;
		employeeData.setEmpId(id);
		
		if(totalHours< 4) {
			status = "absent";
			totalHours =0;
		} else if (totalHours> 4 && totalHours<8) {
			status = "half day";
		}
		else if(totalHours>8) {
			status = "present";
		}
		employeeData.setHoursPresent(totalHours);
		employeeData.setStatus(status);
		
		employeeDataRepository.save(employeeData);
		
		return "Data processed Successfully";
	}

}

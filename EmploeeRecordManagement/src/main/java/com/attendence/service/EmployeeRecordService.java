package com.attendence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendence.DataObject.EmployeeData;
import com.attendence.repository.CheckOutDataRepository;
import com.attendence.repository.CheckinDataRepository;
import com.attendence.repository.EmployeeDataRepository;



@Service
public class EmployeeRecordService {

	@Autowired
	CheckinDataRepository checkinDataRepository;
	
	@Autowired
	CheckOutDataRepository checkoutDataRepository;
	
	@Autowired
	EmployeeDataRepository employeeDataRepository;
	
	public EmployeeData getTotalHours(int id) {
		
		
		EmployeeData empData = employeeDataRepository.findByEmpId(id);
		return empData;
		
		
	}
}

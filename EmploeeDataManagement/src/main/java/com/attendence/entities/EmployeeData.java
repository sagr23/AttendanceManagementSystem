package com.attendence.entities;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Component
@Entity
public class EmployeeData {

	@Id
	@GeneratedValue
	int id;
	int empId;
	int hoursPresent;
	String status;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getHoursPresent() {
		return hoursPresent;
	}
	public void setHoursPresent(int hoursPresent) {
		this.hoursPresent = hoursPresent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

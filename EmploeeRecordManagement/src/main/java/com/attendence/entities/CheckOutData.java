package com.attendence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CheckOutData {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int employeeId;
	private String checkoutDateTime;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getCheckoutDateTime() {
		return checkoutDateTime;
	}
	public void setCheckoutDateTime(String checkoutDateTime) {
		this.checkoutDateTime = checkoutDateTime;
	}
	
}

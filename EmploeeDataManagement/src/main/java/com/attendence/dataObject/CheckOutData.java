package com.attendence.dataObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CheckOutData {
	
	@Id
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

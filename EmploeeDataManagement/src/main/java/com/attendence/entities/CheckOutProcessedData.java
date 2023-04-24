package com.attendence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CheckOutProcessedData {
	
	@Id
	@GeneratedValue
	private int id;
	private String checkoutDate;
	private String employeeId;
	private String checkoutDateTime;
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String string) {
		this.employeeId = string;
	}
	
	public String getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(String checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public String getCheckinDateTime() {
		return checkoutDateTime;
	}
	public void setCheckinDateTime(String checkoutDateTime) {
		this.checkoutDateTime = checkoutDateTime;
	}
	@Override
	public String toString() {
		return "CheckInData [id=" + id + ", employeeId=" + employeeId + ", checkoutDateTime=" + checkoutDateTime + "]";
	}
	
	
}

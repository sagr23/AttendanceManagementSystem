package com.attendence.dataObject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CheckInData {
	
	@Id
	private int id;
	
	private int employeeId;
	private String checkinDateTime;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getCheckinDateTime() {
		return checkinDateTime;
	}
	public void setCheckinDateTime(String checkinDateTime) {
		this.checkinDateTime = checkinDateTime;
	}
	@Override
	public String toString() {
		return "CheckInData [id=" + id + ", employeeId=" + employeeId + ", checkinDateTime=" + checkinDateTime + "]";
	}
	
	
}

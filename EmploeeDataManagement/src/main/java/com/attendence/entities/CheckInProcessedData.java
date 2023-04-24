package com.attendence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CheckInProcessedData {
	
	@Id
	@GeneratedValue
	private int id;
	private String employeeId;
	private String checkinDate;
	private String checkinDateTime;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
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

package com.attendence.Entity;

public class CheckInData  {
	
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
	
}

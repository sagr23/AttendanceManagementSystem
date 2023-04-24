package com.attendence.Entity;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonDeserialize
public class CheckInData2  implements Deserializer{
	
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
	public Object deserialize(String topic, byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

package com.attendence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.attendence.entities.CheckInData;
import com.attendence.entities.CheckOutData;
import com.attendence.repository.CheckOutDataRepository;
import com.attendence.repository.CheckinDataRepository;

@Repository
public class LoggingDao {

	@Autowired
	CheckinDataRepository checkinDataRepository;
	
	@Autowired
	CheckOutDataRepository checkoutDataRepository;

	public void saveCheckInData(String checkInDate) {

		
		String[] str = checkInDate.split("##");
		CheckInData checkInData = new CheckInData();
		checkInData.setEmployeeId(Integer.parseInt(str[0]));
		checkInData.setCheckinDateTime(str[1]);
		checkinDataRepository.save(checkInData);

	}

	public void saveCheckOutData(String checkOutDate) {

		String[] str = checkOutDate.split("##");
		CheckOutData checkOutData = new CheckOutData();
		checkOutData.setEmployeeId(Integer.parseInt(str[0]));
		checkOutData.setCheckoutDateTime(str[1]);
		checkoutDataRepository.save(checkOutData);

	}

}

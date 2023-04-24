package com.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.dataObject.CheckInData;
import com.attendence.entities.CheckInProcessedData;

public interface CheckinProcessedDataRepository extends JpaRepository<CheckInProcessedData, Integer> {

	

}

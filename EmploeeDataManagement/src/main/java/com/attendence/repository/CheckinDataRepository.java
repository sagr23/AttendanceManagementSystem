package com.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.dataObject.CheckInData;

public interface CheckinDataRepository extends JpaRepository<CheckInData, Integer> {

	Object findByEmployeeId(int id);

	List<CheckInData> findAllByEmployeeId(int id);

}

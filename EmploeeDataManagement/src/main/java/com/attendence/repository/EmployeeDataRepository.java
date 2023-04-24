package com.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.dataObject.CheckInData;
import com.attendence.entities.EmployeeData;

public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Integer> {

	/*
	 * Object findByEmployeeId(int id);
	 * 
	 * List<CheckInData> findAllByEmployeeId(int id);
	 */

}

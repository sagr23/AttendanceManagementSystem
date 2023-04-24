package com.attendence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.DataObject.EmployeeData;

public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Integer> {

	
	 EmployeeData findByEmpId(int id);
	 
	//List<CheckInData> findAllByEmployeeId(int id);
	

}

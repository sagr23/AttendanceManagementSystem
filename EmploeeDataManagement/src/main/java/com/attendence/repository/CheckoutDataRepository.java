package com.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.dataObject.CheckOutData;

public interface CheckoutDataRepository extends JpaRepository<CheckOutData, Integer> {

	Object findByEmployeeId(int id);

	List<CheckOutData> findAllByEmployeeId(int id);

}

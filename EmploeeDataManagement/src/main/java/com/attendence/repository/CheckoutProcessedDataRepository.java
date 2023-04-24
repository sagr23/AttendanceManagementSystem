package com.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.dataObject.CheckOutData;
import com.attendence.entities.CheckOutProcessedData;

public interface CheckoutProcessedDataRepository extends JpaRepository<CheckOutProcessedData, Integer> {

	

}

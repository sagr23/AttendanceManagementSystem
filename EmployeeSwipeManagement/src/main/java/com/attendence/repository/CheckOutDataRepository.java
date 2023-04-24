package com.attendence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.entities.CheckOutData;

public interface CheckOutDataRepository extends JpaRepository<CheckOutData, Integer> {

}

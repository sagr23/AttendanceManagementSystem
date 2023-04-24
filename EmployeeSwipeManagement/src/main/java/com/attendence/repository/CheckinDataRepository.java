package com.attendence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendence.entities.CheckInData;

public interface CheckinDataRepository extends JpaRepository<CheckInData, Integer> {

}

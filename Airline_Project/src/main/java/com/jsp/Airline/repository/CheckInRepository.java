package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Check_In;

public interface CheckInRepository extends JpaRepository<Check_In , Integer> {

}

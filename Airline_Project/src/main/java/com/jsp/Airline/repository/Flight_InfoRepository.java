package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Flight_Info;

public interface Flight_InfoRepository extends JpaRepository<Flight_Info, Integer> {

}

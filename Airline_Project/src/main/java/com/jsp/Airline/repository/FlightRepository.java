package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

}

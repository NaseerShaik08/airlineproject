package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Airline_Info;

public interface AirlineInfoRepository extends JpaRepository<Airline_Info, Integer> {

}

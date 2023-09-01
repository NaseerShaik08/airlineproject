package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Fare;

public interface FareRepository extends JpaRepository<Fare, Integer> {

}

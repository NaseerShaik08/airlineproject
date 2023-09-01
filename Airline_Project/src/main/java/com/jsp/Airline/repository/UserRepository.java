package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}

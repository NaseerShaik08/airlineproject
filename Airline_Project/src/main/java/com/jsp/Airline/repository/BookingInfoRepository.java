package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Booking_Info;

public interface BookingInfoRepository extends JpaRepository<Booking_Info , Integer> {

}

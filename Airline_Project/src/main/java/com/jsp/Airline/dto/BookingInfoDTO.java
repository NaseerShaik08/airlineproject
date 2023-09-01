package com.jsp.Airline.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookingInfoDTO {
	private LocalDate Booking_Date;
	private String Destination;
	private double Fare;
	private LocalDate Fly_Date;
	private int Flight_No;
	private boolean Status;
	private LocalTime Flight_Time;
	private String Current_City;
	
}

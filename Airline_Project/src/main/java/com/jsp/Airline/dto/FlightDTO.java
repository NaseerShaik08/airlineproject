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
public class FlightDTO {
	private String Destination;
	private LocalDate Flight_Date;
	private int Flight_No;
	private LocalTime Flight_Time;
	private String Current_Location;
	
	private FareDTO fareDTO;
	private InventoryDTO inventoryDTO;
}

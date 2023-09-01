package com.jsp.Airline.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "Flight_table")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Flight_Id;
	private String Destination;
	private LocalDate Flight_Date;
	private int Flight_No;
	private LocalTime Flight_Time;
	private String Current_Location;
	//private int Fare_Id;				//F.K
	//private int FlightInfo_Id;			//F.K
	//private int Inventory_Id;			//F.k
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "fare_Id")
	private Fare fare;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name = "flightInfo_id")
	private Flight_Info flight_info;
	
	@OneToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;
}

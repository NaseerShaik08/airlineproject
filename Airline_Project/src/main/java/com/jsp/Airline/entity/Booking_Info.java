package com.jsp.Airline.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Booking_Info_table")
public class Booking_Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Booking_Id;
	private LocalDate Booking_Date;
	private String Destination;
	private Double Fare;
	private LocalDate Fly_Date;
	private int Flight_No;
	private boolean status;
	private LocalTime Flight_Time;
	private String Current_City;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "booking_info")
	private List<Passanger> passanger;
}

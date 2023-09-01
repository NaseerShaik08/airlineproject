package com.jsp.Airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Flight_Info_table")
public class Flight_Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int FlightInfo_Id;
	private int Flight_No;
	private String Flight_Type;
	//private int Airline_Id;			//F.k
	
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "Airline_id")
	private Airline_Info airline_info;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER , mappedBy = "flight_info")
	private Flight flight;
	
	
}

package com.jsp.Airline.entity;

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
@Table(name = "Airline_Info_table")
public class Airline_Info {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Airline_Id;
	private String Airline_Name;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER ,mappedBy = "airline_info")
	private List<Flight_Info> flight_info;
}

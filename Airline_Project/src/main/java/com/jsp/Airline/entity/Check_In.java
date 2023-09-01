package com.jsp.Airline.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CheckIn_table")
public class Check_In {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CheckIn_Id;
	private int Seat_No;
	private String Gate_No;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER ,mappedBy = "check_in")
	private Passanger passanger;
}

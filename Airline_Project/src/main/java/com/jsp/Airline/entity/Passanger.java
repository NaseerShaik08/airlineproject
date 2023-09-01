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
@Table(name = "Passanger_table")
public class Passanger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Passanger_Id;
	private String Email_Id;
	private String First_Name;
	private String Last_Name;
	private String Gender;
	private long Mobile_No;
	//private int Booking_Id;			//F.k
	//private int CheckIn_Id;			//F.K
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "booking_id")
	private Booking_Info booking_info;
	
	@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name = "checkin_id")
	private Check_In check_in;
}

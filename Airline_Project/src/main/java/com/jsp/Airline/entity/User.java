package com.jsp.Airline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "User_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int User_Id;
	private String First_Name;
	private String Last_Name;
	private long Mobile_No;
	private String Gender;
	private String UserName;
	private String Password;
}

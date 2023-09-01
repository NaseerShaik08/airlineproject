package com.jsp.Airline.dto;

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
public class PassangerDTO {
	private String Email_Id;
	private String First_Name;
	private String Last_Name;
	private String Gender;
	private long Mobile_No;
	
}

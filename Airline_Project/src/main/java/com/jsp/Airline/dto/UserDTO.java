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
public class UserDTO {
	private String firstName;
	private String lastName;
	private long mobileNo;
	private String gender;
	private String userName;
	private String password;
}

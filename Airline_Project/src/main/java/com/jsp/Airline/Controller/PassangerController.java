package com.jsp.Airline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Airline.dto.PassangerDTO;
import com.jsp.Airline.service.AdminService;

@RestController		//to make use of restapi
@RequestMapping("/api/v1")		
public class PassangerController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/passangers/{booking_Id}/{checkIn_Id}")
	public ResponseEntity<String> addPassanger(@RequestBody PassangerDTO dto , @PathVariable("booking_Id") int Booking_Id
																				,@PathVariable("checkIn_Id") int CheckIn_Id) {
		
		System.out.println(dto);
		//return adminService.addPassanger(dto);
		int id= adminService.addPassanger(dto , Booking_Id , CheckIn_Id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
}

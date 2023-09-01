package com.jsp.Airline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Airline.dto.CheckInDTO;
import com.jsp.Airline.service.AdminService;

@RestController		//to make use of restapi
@RequestMapping("/api/v1")		//to prpvide unique path for bookcontroller
public class CheckInController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/checkin")
	public ResponseEntity<String> addCheckIn(@RequestBody CheckInDTO dto) {
		
		System.out.println(dto);
		//return adminService.addCheckIn(dto);
		int id= adminService.addCheckIn(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
}

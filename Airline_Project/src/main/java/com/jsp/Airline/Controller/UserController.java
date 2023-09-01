package com.jsp.Airline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Airline.dto.UserDTO;
import com.jsp.Airline.service.AdminService;

@RestController		//to make use of restapi
@RequestMapping("/api/v1")	
public class UserController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@RequestBody UserDTO dto) {
		
		System.out.println(dto);
		//return userService.addUser(dto);
		int id= adminService.addUser(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
}

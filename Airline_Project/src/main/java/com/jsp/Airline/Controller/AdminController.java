package com.jsp.Airline.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Airline.dto.AirlineInfoDTO;
import com.jsp.Airline.dto.FareDTO;
import com.jsp.Airline.dto.FlightDTO;
import com.jsp.Airline.dto.Flight_InfoDTO;
import com.jsp.Airline.dto.InventoryDTO;
import com.jsp.Airline.service.AdminService;

@RestController		//to make use of restapi
@RequestMapping("/api/v1")	
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/airlineinfo")
	public ResponseEntity<String> addAirlineInfo(@RequestBody AirlineInfoDTO dto) {
		
		System.out.println(dto);
		//return adminService.addAirlineInfo(dto);
		int id= adminService.addAirlineInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
	
	@PostMapping("/fare")
	public ResponseEntity<String> addFare(@RequestBody FareDTO dto) {
		
		System.out.println(dto);
		int id = adminService.addFare(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
	
	@PostMapping("/flightinfo/{airline_Id}")
	public ResponseEntity<String> addFlightInfo(@RequestBody Flight_InfoDTO dto ,@PathVariable("airline_Id") int airline_Id) {
		System.out.println(dto);
		int id = adminService.addFlightInfo(dto , airline_Id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
	
	@PostMapping("/inventory")
	public ResponseEntity<String> addInventory(@RequestBody InventoryDTO dto) {
		System.out.println(dto);
		int id = adminService.addInventory(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
	
	@PostMapping("/flight/{fare_Id}/{flightInfo_Id}/{inventory_Id}")
	public ResponseEntity<String> addFlight(@RequestBody FlightDTO dto,@PathVariable("fare_Id") int Fare_Id
																		,@PathVariable("flightInfo_Id") int FlightInfo_Id
																		,@PathVariable("inventory_Id") int Inventory_Id) {
		System.out.println(dto);
		int id = adminService.addFlight(dto , Fare_Id , FlightInfo_Id , Inventory_Id);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
	
	//To get All Flight Details
	@GetMapping("/allFlights")
	public List<FlightDTO> getAllFlights() {
		return adminService.getAllFlights();
	}
}

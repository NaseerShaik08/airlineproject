package com.jsp.Airline.Controller;

import java.time.LocalDate;
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

import com.jsp.Airline.dto.BookingInfoDTO;
import com.jsp.Airline.dto.FlightDTO;
import com.jsp.Airline.service.AdminService;

@RestController		//to make use of restapi
@RequestMapping("/api/v1")	
public class BookingInfoController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/bookinginfo")
	public ResponseEntity<String> addBookingInfo(@RequestBody BookingInfoDTO dto) {
		
		System.out.println(dto);
		//return adminService.addBookingInfo(dto);
		int id= adminService.addBookingInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Id is " +id);
	}
	
	//create an api to get details from db based on id
	@GetMapping("/booking/{bid}")
	public ResponseEntity<BookingInfoDTO> findBookingInfo(@PathVariable("bid") int id) {
		
		if (adminService.findBookingInfo(id)!=null) 
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.findBookingInfo(id));
		}
		else 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
	//create an api to get all booking details
	@GetMapping("/bookings")
	public List<BookingInfoDTO> getAllBookings() {
		return adminService.getAllBookings();
	}
	
	/*public ResponseEntity<FlightDTO> searchByCurrentCityAndDestinationAndDate(@PathVariable("CurrentLocation") 
										String CurrentLocation , @PathVariable("Destination") String Destination ,
										@PathVariable("CurrentDate") LocalDate CurrentDate) {
		
		if (adminService.searchByCurrentCityAndDestinationAndDate(CurrentLocation && Destination && CurrentDate)!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.searchByCurrentCityAndDestinationAndDate(null))
		} else {

		}
		
	}*/

}

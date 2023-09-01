
package com.jsp.Airline.service;

import java.util.List;

import com.jsp.Airline.dto.AirlineInfoDTO;
import com.jsp.Airline.dto.BookingInfoDTO;
import com.jsp.Airline.dto.CheckInDTO;
import com.jsp.Airline.dto.FareDTO;
import com.jsp.Airline.dto.FlightDTO;
import com.jsp.Airline.dto.Flight_InfoDTO;
import com.jsp.Airline.dto.InventoryDTO;
import com.jsp.Airline.dto.PassangerDTO;
import com.jsp.Airline.dto.UserDTO;

public interface AdminService {
	int addUser(UserDTO dto);
	int addAirlineInfo(AirlineInfoDTO dto);
	int addBookingInfo(BookingInfoDTO dto);
	int addCheckIn(CheckInDTO dto);
	int addFare(FareDTO dto);
	int addFlightInfo(Flight_InfoDTO dto , int airline_Id);
	int addInventory(InventoryDTO dto);
	int addFlight(FlightDTO dto , int Fare_Id , int FlightInfo_Id , int Inventory_Id);
	int addPassanger(PassangerDTO dto , int Booking_Id , int checkIn_Id);
	
	
	
	BookingInfoDTO findBookingInfo(int bid);
	List<BookingInfoDTO> getAllBookings();
	List<FlightDTO> getAllFlights();
	//List<FlightDTO> searchByFlightNo(int FlightNo);
	List<FlightDTO> searchByCurrentCityAndDestinationAndDate(FlightDTO flightDTO);
}

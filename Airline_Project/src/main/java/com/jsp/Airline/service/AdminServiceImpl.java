package com.jsp.Airline.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.Airline.dto.AirlineInfoDTO;
import com.jsp.Airline.dto.BookingInfoDTO;
import com.jsp.Airline.dto.CheckInDTO;
import com.jsp.Airline.dto.FareDTO;
import com.jsp.Airline.dto.FlightDTO;
import com.jsp.Airline.dto.Flight_InfoDTO;
import com.jsp.Airline.dto.InventoryDTO;
import com.jsp.Airline.dto.PassangerDTO;
import com.jsp.Airline.dto.UserDTO;
import com.jsp.Airline.entity.Airline_Info;
import com.jsp.Airline.entity.Booking_Info;
import com.jsp.Airline.entity.Check_In;
import com.jsp.Airline.entity.Fare;
import com.jsp.Airline.entity.Flight;
import com.jsp.Airline.entity.Flight_Info;
import com.jsp.Airline.entity.Inventory;
import com.jsp.Airline.entity.Passanger;
import com.jsp.Airline.entity.User;
import com.jsp.Airline.repository.AirlineInfoRepository;
import com.jsp.Airline.repository.BookingInfoRepository;
import com.jsp.Airline.repository.CheckInRepository;
import com.jsp.Airline.repository.FareRepository;
import com.jsp.Airline.repository.FlightRepository;
import com.jsp.Airline.repository.Flight_InfoRepository;
import com.jsp.Airline.repository.InventoryRepository;
import com.jsp.Airline.repository.PassangerRepository;
import com.jsp.Airline.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	//To Add User Details
	@Autowired
	private UserRepository userRepository;
	@Override
	public int addUser(UserDTO dto) {
		User u1 = userRepository.save(User.builder()
								.First_Name(dto.getFirstName())
								.Last_Name(dto.getLastName())
								.Mobile_No(dto.getMobileNo())
								.Gender(dto.getGender())
								.UserName(dto.getUserName())
								.Password(dto.getPassword()).build());
		System.out.println(u1);
		return u1.getUser_Id();
		
	}
	
	
	//To Add Airline Info Details
	@Autowired
	private AirlineInfoRepository airlineInfoRepository;
	
	@Override
	public int addAirlineInfo(AirlineInfoDTO dto) {
		Airline_Info a1 = airlineInfoRepository.save(Airline_Info.builder()
												.Airline_Name(dto.getAirline_Name()).build());
		System.out.println(a1);
		return a1.getAirline_Id();
	}

	
	//To Add Booking info Details 
	@Autowired
	private BookingInfoRepository bookingInfoRepository;
	
	@Override
	public int addBookingInfo(BookingInfoDTO dto) {
		Booking_Info b1 = bookingInfoRepository.save(Booking_Info.builder()
												.Booking_Date(dto.getBooking_Date())
												.Destination(dto.getDestination())
												.Fare(dto.getFare())
												.Fly_Date(dto.getFly_Date())
												.Flight_No(dto.getFlight_No())
												.status(dto.isStatus())
												.Flight_Time(dto.getFlight_Time())
												.Current_City(dto.getCurrent_City())
												.build());
		System.out.println(b1);
		return b1.getBooking_Id();
	}

	//To add CheckIn Details
	@Autowired
	private CheckInRepository checkInRepository;
	
	@Override
	public int addCheckIn(CheckInDTO dto) {
		Check_In c1 = checkInRepository.save(Check_In.builder()
										.Seat_No(dto.getSeat_No())
										.Gate_No(dto.getGate_No())
										.build());
		System.out.println(c1);
		return c1.getCheckIn_Id();
	}
	
	
	//To add fare Details
	@Autowired
	private FareRepository fareRepository;
	
	@Override
	public int addFare(FareDTO dto) {
		Fare f1 = fareRepository.save(Fare.builder()
								.Currency(dto.getCurrency())
								.Amount(dto.getAmount()).build());
		System.out.println(f1);
		return f1.getFare_Id();
	}

	//To Add Flight Info Details
	@Autowired
	private Flight_InfoRepository flight_InfoRepository;
	
	@Autowired
	private AirlineInfoRepository airlineInfoRepository2;
	
	@Override
	public int addFlightInfo(Flight_InfoDTO dto , int airline_Id) {
		
		Airline_Info ai = airlineInfoRepository2.findById(airline_Id).get();
		
		Flight_Info fi = Flight_Info.builder()
									.Flight_No(dto.getFlight_No())
									.Flight_Type(dto.getFlight_Type())
									.airline_info(ai)
									.build();
		System.out.println(fi);
		return flight_InfoRepository.save(fi).getFlightInfo_Id();
	}
	
	//To add Inventory
	@Autowired
	private InventoryRepository inventoryRepository;
	@Override
	public int addInventory(InventoryDTO dto) {
		Inventory i = inventoryRepository.save(Inventory.builder()
											.Count(dto.getCount()).build());
		System.out.println(i);
		return i.getInventory_Id();
	}
	
	//To Add Flight Details
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private FareRepository fareRepository2;
	@Autowired
	private Flight_InfoRepository flight_InfoRepository2;
	@Autowired
	private InventoryRepository inventoryRepository2;
	@Override
	public int addFlight(FlightDTO dto , int Fare_Id , int FlightInfo_Id , int Inventory_Id) {
		
		Fare fare = fareRepository2.findById(Fare_Id).get();
		Flight_Info fli = flight_InfoRepository2.findById(FlightInfo_Id).get();
		Inventory i = inventoryRepository2.findById(Inventory_Id).get();
		
		Flight fl = flightRepository.save(Flight.builder()
							.Destination(dto.getDestination())  
							.Flight_Date(dto.getFlight_Date())
							.Flight_No(dto.getFlight_No())
							.Flight_Time(dto.getFlight_Time())
							.Current_Location(dto.getCurrent_Location())
							.fare(fare)
							.flight_info(fli)
							.inventory(i)
							.build());
		System.out.println(fl);
		return flightRepository.save(fl).getFlight_Id();
	}
	
	
	//To Add passanger Details
	@Autowired
	private PassangerRepository passangerRepository;
	@Autowired
	private BookingInfoRepository bookingInfoRepository2;
	@Autowired
	private CheckInRepository checkInRepository2;

	@Override
	public int addPassanger(PassangerDTO dto ,int Booking_Id,  int checkIn_Id) {
		Booking_Info bookingInfo = bookingInfoRepository2.findById(Booking_Id).get();
		Check_In checkIn = checkInRepository2.findById(checkIn_Id).get();
		
		Passanger p1 = Passanger.builder()
								.Email_Id(dto.getEmail_Id())
								.First_Name(dto.getFirst_Name())
								.Last_Name(dto.getLast_Name())
								.Mobile_No(dto.getMobile_No())
								.Gender(dto.getGender())
								.booking_info(bookingInfo)
								.check_in(checkIn)
								.build();
		System.out.println(p1);
		return passangerRepository.save(p1).getPassanger_Id();
	}

	
	
	//to fetch booking details by id
	
	@Override
	public BookingInfoDTO findBookingInfo(int bid) {
		Optional<Booking_Info> bookingInfoObject = bookingInfoRepository.findById(bid);
		if (bookingInfoObject.isPresent()) {
			Booking_Info b1= bookingInfoObject.get();	

			BookingInfoDTO dto = BookingInfoDTO.builder()
							.Booking_Date(b1.getBooking_Date())
							.Destination(b1.getDestination())
							.Fare(b1.getFare())
							.Fly_Date(b1.getFly_Date())
							.Flight_No(b1.getFlight_No())
							.Flight_Time(b1.getFlight_Time())
							.Current_City(b1.getCurrent_City())
							.build();
			return dto;
		} 
		else 
		{
			return null;
		}
	}
	
	//To get All booking Details
	@Override
	public List<BookingInfoDTO> getAllBookings() {
		List<Booking_Info> bookings = bookingInfoRepository.findAll();
		
		if (bookings.size()>0) {
			List<BookingInfoDTO> dto = bookings.stream().map(t -> BookingInfoDTO.builder()
																				.Booking_Date(t.getBooking_Date())
																				.Destination(t.getDestination())
																				.Fare(t.getFare())
																				.Fly_Date(t.getFly_Date())
																				.Flight_No(t.getFlight_No())
																				.Status(t.isStatus())
																				.Flight_Time(t.getFlight_Time())
																				.Current_City(t.getCurrent_City()).build())
																				.collect(Collectors.toList());
			return dto;
		} 
		else {
			return null;
		}
	}



	@Override
	public List<FlightDTO> getAllFlights() {
		return flightRepository.findAll().stream()
										.map(flightDb ->FlightDTO.builder().Current_Location(flightDb.getCurrent_Location())
										.Destination(flightDb.getDestination()).Flight_Date(flightDb.getFlight_Date())
										.Flight_Time(flightDb.getFlight_Time()).Flight_No(flightDb.getFlight_No())
										.fareDTO(FareDTO.builder().Amount(flightDb.getFare().getAmount())
										.Currency(flightDb.getFare().getCurrency()).build())
										.inventoryDTO(InventoryDTO.builder().Count(flightDb.getInventory().getCount()).build())
										.build()).collect(Collectors.toList());
	}



	/*@Override
	public List<FlightDTO> searchByFlightNo(int FlightNo) {
		return getAllFlights().stream().filter(flight ->flight.getFlight_No().equals(FlightNo)).collect(Collectors.toList());
	}*/



	@Override
	public List<FlightDTO> searchByCurrentCityAndDestinationAndDate(FlightDTO flightDTO) {
		return getAllFlights().stream()
								.filter(flight ->flight.getCurrent_Location().equals(flightDTO.getCurrent_Location())
									&& flight.getDestination().equals(flightDTO.getDestination())
									&& flight.getFlight_Date().equals(flightDTO.getFlight_Date())).collect(Collectors.toList());
	}

}

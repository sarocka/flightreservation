package flightReservation;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import flightReservation.model.Flight;
import flightReservation.model.User;
import flightReservation.repository.FlightRepository;
import flightReservation.repository.UserRepository;



@Component
public class TestData {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
	
	@PostConstruct
	public void init() {
		
		User user = new User();
		user.setFirstname("Sara");
		user.setLastname("Rat");
		user.setPassword("Petruska");
		user.setUsername("sara.rat.ns.90@gmail.com");
		userRepository.save(user);
		
		Flight flight1 = new Flight();
		flight1.setArrivalCity("Frankfurt");
		flight1.setDepartureCity("Belgrade");
		try {
			Date date1 = format.parse("1.05.2019");
			flight1.setDepartureDate(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		flight1.setEstimatedDepartureTime(new Timestamp(System.currentTimeMillis()));
		flight1.setFlightNo("1a8g2");
		flight1.setOperatingAirlines("Lufthansa");
		flightRepository.save(flight1);
		
		Flight flight2 = new Flight();
		flight2.setArrivalCity("Barselona");
		flight2.setDepartureCity("Milan");
		try {
			Date date2 = format.parse("12.06.2019");
			flight1.setDepartureDate(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		flight2.setEstimatedDepartureTime(new Timestamp(System.currentTimeMillis()));
		flight2.setFlightNo("1a9g2");
		flight2.setOperatingAirlines("AliItalia");
		flightRepository.save(flight2);
	}
}

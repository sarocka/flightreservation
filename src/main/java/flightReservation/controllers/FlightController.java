package flightReservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import flightReservation.model.Flight;
import flightReservation.repository.FlightRepository;


@Controller
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam(value="departureCity", required=false)String departureCity,@RequestParam (value="arrivalCity", required=false)String arrivalCity, 
			@RequestParam (value="departureDate", required=false) @DateTimeFormat (pattern="dd.mm.yyyy")Date departureDate, ModelMap modelMap ) {
		
		List<Flight> flights = null;
		if (departureCity!=null || arrivalCity !=null || departureDate != null) {
			flights = flightRepository.findFlights(departureCity, arrivalCity, departureDate);
		}
		
		if (flights.isEmpty()) {
			modelMap.addAttribute("message", "No available flights. Try with different search parameters");
			return "findFlights";
		} else {
			modelMap.addAttribute("flights", flights);
		}
		return "displayFlights";
	}
}

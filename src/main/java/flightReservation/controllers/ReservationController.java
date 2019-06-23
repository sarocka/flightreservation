package flightReservation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import flightReservation.model.Flight;
import flightReservation.model.Reservation;
import flightReservation.model.ReservationRequest;
import flightReservation.repository.FlightRepository;
import flightReservation.service.ReservationService;


@Controller
public class ReservationController {
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("id")Long flightId, ModelMap modelMap) {
		if (flightId==null) {
			System.out.println("Flight id is null!");
		}
		Flight flight = flightRepository.findOne(flightId);
		modelMap.addAttribute("flight", flight);
		return "displayCompleteReservation";
	}
	@RequestMapping("completeReservation")
	public String completeReservation(@ModelAttribute ReservationRequest request, ModelMap modelMap) {
		
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("message", "Reservation completed successfully! The id of the reservation is: "+reservation.getId());
		return "reservationConfirmation";
	}

}

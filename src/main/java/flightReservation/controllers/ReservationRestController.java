package flightReservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flightReservation.model.Reservation;
import flightReservation.repository.ReservationRepository;

@RestController
public class ReservationRestController {
	@Autowired
	private ReservationRepository reservationRepository;
	
	@RequestMapping(value="/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")Long id) {
		Reservation reservation =reservationRepository.findOne(id);
		return reservation;
	}
	
	@RequestMapping(value="/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest updateRequest) {
		Reservation reservation = reservationRepository.findOne(updateRequest.getId());
		reservation.setCheckedIn(updateRequest.isCheckedIn());
		reservation.setNumberOfBags(updateRequest.getNumberOfBags());
		Reservation saved = reservationRepository.save(reservation);
		return saved;
	}
}

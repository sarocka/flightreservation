package flightReservation.service;

import flightReservation.model.Reservation;
import flightReservation.model.ReservationRequest;

public interface ReservationService {

	public Reservation bookFlight(ReservationRequest request);
}

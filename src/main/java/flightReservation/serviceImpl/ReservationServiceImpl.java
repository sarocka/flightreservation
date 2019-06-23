package flightReservation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import flightReservation.model.Flight;
import flightReservation.model.Passenger;
import flightReservation.model.Reservation;
import flightReservation.model.ReservationRequest;
import flightReservation.repository.FlightRepository;
import flightReservation.repository.PassengerRepository;
import flightReservation.repository.ReservationRepository;
import flightReservation.service.ReservationService;
import flightReservation.util.EmailUtil;
import flightReservation.util.PDFGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	

	@Autowired
	EmailUtil emailUtil;
	

	@Autowired
	PDFGenerator pdfGenerator;
	
	@Override
	public Reservation bookFlight(ReservationRequest request) {
	Long flightId = request.getFlightId();
	Flight flight = flightRepository.findOne(flightId);
	Passenger passenger = new Passenger();
	
	passenger.setFirstname(request.getPassengerFirstname());
	passenger.setLastname(request.getPassengerLastName());
	passenger.setEmail(request.getPassengerEmail());
	passenger.setPhone(request.getPassengerPhone());
	
	Passenger savedPassenger = passengerRepository.save(passenger);
	Reservation reservation = new Reservation();
	reservation.setFlight(flight);
	reservation.setPassenger(savedPassenger);
	reservation.setCheckedIn(false);
	
	Reservation savedReservation = reservationRepository.save(reservation);

	pdfGenerator.generatePdf(savedReservation, "C:\\Users\\Sara\\Desktop\\mojaSunca!"+savedReservation.getId()+".pdf");
	emailUtil.sendItinerary(passenger.getEmail(), "C:\\Users\\Sara\\Desktop\\mojaSunca!"+savedReservation.getId()+".pdf");
	
		return savedReservation;
	}

}

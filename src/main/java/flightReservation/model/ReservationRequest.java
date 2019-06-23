package flightReservation.model;

public class ReservationRequest {
//DTO class
private Long flightId;
private String passengerFirstname;
private String passengerLastname;
private String passengerEmail;
private String passengerPhone;


	
public String getPassengerFirstname() {
	return passengerFirstname;
}

public void setPassengerFirstname(String passengerFirstname) {
	this.passengerFirstname = passengerFirstname;
}

public String getPassengerLastName() {
	return passengerLastname;
}

public void setPassengerLastName(String passengerLastName) {
	this.passengerLastname = passengerLastName;
}

public String getPassengerEmail() {
	return passengerEmail;
}

public void setPassengerEmail(String passengerEmail) {
	this.passengerEmail = passengerEmail;
}

public String getPassengerPhone() {
	return passengerPhone;
}

public void setPassengerPhone(String passengerPhone) {
	this.passengerPhone = passengerPhone;
}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	
	
}

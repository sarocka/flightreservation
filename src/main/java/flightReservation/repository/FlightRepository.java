package flightReservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import flightReservation.model.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("FROM Flight f WHERE "
			+ "(:departureCity IS NULL or f.departureCity like :departureCity) AND "
			+ " (:arrivalCity IS NULL or f.arrivalCity like :arrivalCity) AND "
			+ " (:departureDate IS NULL or f.departureDate like :departureDate) ")
	List<Flight> findFlights(@Param("departureCity") String departureCity,@Param("arrivalCity") String arrivalCity, @Param("departureDate") Date departureDate);
	
	
	
}

package flightReservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flightReservation.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String email);

}

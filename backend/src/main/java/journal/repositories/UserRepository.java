package journal.repositories;

import journal.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

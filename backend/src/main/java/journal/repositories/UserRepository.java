package journal.repositories;

import journal.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE userName = :userName")
    Optional<User> findByUserName(@Param("userName") String userName);

    Optional<User> findById(long id);

    Boolean existsByUsername(String username);

}

package journal.services;

import journal.models.entities.User;
import journal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @author Evgeniy Ukhanov
 */


public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }

}

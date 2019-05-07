package journal.security;

import journal.models.entities.User;
import journal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeniy Ukhanov
 */


public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        User user = userService.findByUserName(userName)
                .orElseThrow(() ->
                                new UsernameNotFoundException("Пользователь с именем : " + userName + " не найден!")
                );

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userService.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("Пользователь с id = " + id + " не найден!")
        );

        return UserPrincipal.create(user);
    }
}

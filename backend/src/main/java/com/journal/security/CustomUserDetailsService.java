package com.journal.security;

import com.journal.model.entity.User;
import com.journal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Evgeniy Ukhanov
 */


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // Дадим возможность пользователю авторизоваться по логину
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                                new UsernameNotFoundException("Пользователем с указанным логином не найден: "
                                        + username)
                );

        return UserPrincipal.create(user);
    }

    // Этот метод используется JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("Пользователь с указанным id не найден : " + id)
        );

        return UserPrincipal.create(user);
    }
}
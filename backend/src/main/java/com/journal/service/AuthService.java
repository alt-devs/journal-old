package com.journal.service;

import com.journal.exception.AppException;
import com.journal.model.entity.Role;
import com.journal.model.entity.User;
import com.journal.model.enums.RoleName;
import com.journal.model.service.CredentialInput;
import com.journal.model.service.LoginResponse;
import com.journal.payload.ApiResponse;
import com.journal.payload.JwtAuthenticationResponse;
import com.journal.repository.RoleRepository;
import com.journal.repository.UserRepository;
import com.journal.security.JwtTokenProvider;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author Evgeniy Ukhanov
 */


@Service
public class AuthService {

    private static final Logger logger = LogManager.getLogger("AuthController");

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    LoginResponse loginResponse;


//    @PostMapping("/signin")
    @GraphQLQuery(name = "signin")
    public LoginResponse authenticateUser(@GraphQLArgument(name = "credentialInput") CredentialInput credentialInput) {
//    public ResponseEntity<Object> authenticateUser(@GraphQLArgument(name = "credentialInput") CredentialInput credentialInput) {
//        System.out.println("ПРИВА");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentialInput.getUsername(),
                        credentialInput.getPassword()

//                        loginRequest.getUsernameOrEmail(),
//                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
//        HttpSession httpSession.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        String jwt = tokenProvider.generateToken(authentication);
        JwtAuthenticationResponse jar = new JwtAuthenticationResponse(jwt);

        loginResponse.setAccessToken(jar.getAccessToken());
        loginResponse.setTokenType(jar.getTokenType());
        return loginResponse;
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));


//        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        httpSession.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
//        return httpSession.getId();
    }


//    @PostMapping("/signup")
    @GraphQLMutation(name = "signup")
    public ResponseEntity<Object> registerUser(@GraphQLArgument(name = "credentialInput") CredentialInput credentialInput) {
        System.out.println("ПРИВЕТ");
        if(userRepository.existsByUsername(credentialInput.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Пользователь с указанным логином уже присутствует в системе!"),
                    HttpStatus.BAD_REQUEST);
        }

//        if(userRepository.existsByEmail(credentialInput.getEmail())) {
//            return new ResponseEntity(new ApiResponse(false, "Пользователь с указанным email уже присутствует в системе!"),
//                    HttpStatus.BAD_REQUEST);
//        }

        // Creating user's account
        User user = new User(credentialInput.getUsername(),
                             credentialInput.getPassword());

//        User user = new User(credentialInput.getName(), credentialInput.getUsername(),
//                credentialInput.getEmail(), credentialInput.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.USER)
                .orElseThrow(() -> new AppException("Роль пользователя не установлена!"));

        user.setRole(userRole);
//        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Пользователь успешно зарегистрирован!"));
    }
}
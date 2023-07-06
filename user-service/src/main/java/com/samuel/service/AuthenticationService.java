package com.samuel.service;

import com.samuel.config.JwtService;
import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.dto.response.AuthenticationResponse;
import com.samuel.exception.ApiRequest;
import com.samuel.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        if (!authentication.isAuthenticated()) throw new ApiRequest( "User Details cannot be Authenticated", HttpStatus.NOT_ACCEPTABLE);
        else{
            AuthenticationRequest authenticationRequest1 =
                    userRepository.findByEmail(authenticationRequest.getEmail()).
                            map(s -> AuthenticationRequest.builder()
                                    .email(s.getEmail())
                                    .password(s.getPassword())
                                    .build()).get();
            String token = jwtService.generateToken(authenticationRequest);
            return AuthenticationResponse.builder()
                    .token(token)
                    .build();
        }
    }
}

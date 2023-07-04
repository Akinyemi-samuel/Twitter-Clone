package com.samuel.service;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.exception.ApiRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public String login(AuthenticationRequest authenticationRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        if (!authentication.isAuthenticated()) throw new ApiRequest( "error", HttpStatus.NOT_ACCEPTABLE);
        else return "yahhh";
    }
}

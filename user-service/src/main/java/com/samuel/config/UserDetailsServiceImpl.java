package com.samuel.config;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.model.User;
import com.samuel.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService  {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optional = userRepository.findByEmail(username);

        return optional.map(s -> AuthenticationRequest.builder()
                .email(s.getEmail())
                .password(s.getPassword())
                        .role(s.getRole())
                .build())
                .orElseThrow(()-> new UsernameNotFoundException("UserName not found"));

    }
    
}

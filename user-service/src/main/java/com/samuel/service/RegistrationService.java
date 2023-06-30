package com.samuel.service;


import com.samuel.enums.Role;
import com.samuel.exception.ApiRequest;
import com.samuel.dto.request.RegistrationRequest;
import com.samuel.model.User;
import com.samuel.model.UserMetadata;
import com.samuel.repository.UserMetadataRepository;
import com.samuel.repository.UserRepository;
import com.samuel.security.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final UserMetadataRepository userMetadataRepository;

    private final IsEmailValid isemailValid;

    private final EmailService emailService;

    private final JwtService jwtService;

    private final ConfirmationTokenService confirmationTokenService;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String registration(RegistrationRequest registrationRequest, HttpServletRequest httpServletRequest) {

        Optional<User> userOptional = userRepository.findByEmail(registrationRequest.email());

        if (userOptional.isPresent()) throw new ApiRequest("USER ALREADY EXITS", HttpStatus.CONFLICT);


        boolean isEmailValid = isemailValid.test(registrationRequest.email());
        if (!isEmailValid) throw new ApiRequest("EMAIL INVALID", HttpStatus.CONFLICT);

        User user = User.builder()
                .fullname(registrationRequest.fullName())
                .email(registrationRequest.email())
                .password(passwordEncoder.encode(registrationRequest.password()))
                .role(Role.USER)
                .build();
        userRepository.saveAndFlush(user);

        UserMetadata userMetadata = UserMetadata.builder()
                .user(user)
                .birthDate(registrationRequest.dateOfBirth())
                .build();
        userMetadataRepository.save(userMetadata);

        String registeredUserLastname =
                getLastnameFromFullname(registrationRequest.fullName());

        String token = confirmationTokenService.createConfirmationToken(user);
        String url = applicationUrl(httpServletRequest) + "/API/V1/REGISTRATION/confirm?token=" + token;

        emailService.send(user.getEmail(), emailService.buildEmail(registeredUserLastname, url));

        return "Please Check your Email to confirm your registration";

    }

    // FILTERS THE USER FULL-NAME AND GETS THE LASTNAME ONLY
    private String getLastnameFromFullname(String fullName) {
        String trimmedFullname = fullName.trim();
        return trimmedFullname.substring(trimmedFullname.lastIndexOf(" ") + 1);
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
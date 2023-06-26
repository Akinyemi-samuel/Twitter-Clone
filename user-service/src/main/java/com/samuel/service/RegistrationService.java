package com.samuel.service;

import com.samuel.Exception.ApiRequest;
import com.samuel.dto.request.RegistrationRequest;
import com.samuel.model.User;
import com.samuel.model.UserMetadata;
import com.samuel.repository.UserMetadataRepository;
import com.samuel.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final UserMetadataRepository userMetadataRepository;

    private final IsEmailValid isemailValid;

    private final ConfirmationTokenService confirmationTokenService;

    @Transactional
    public String registration(RegistrationRequest registrationRequest) {

        Optional<User> userOptional = userRepository.findByEmail(registrationRequest.email());

        if (userOptional.isPresent()) {
            throw new ApiRequest("USER ALREADY EXITS", HttpStatus.CONFLICT);
        }

        Boolean isEmailValid = isemailValid.test(registrationRequest.email());
        if (!isEmailValid) {
            throw new ApiRequest("EMAIL INVALID", HttpStatus.CONFLICT);
        }

        User user = User.builder()
                .fullname(registrationRequest.fullName())
                .email(registrationRequest.email())
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

        return token;
    }
//

    // FILTERS THE USER FULL-NAME AND GETS THE LASTNAME ONLY
    public String getLastnameFromFullname(String fullName) {
        String trimmedFullname = fullName.trim();
        return trimmedFullname.substring(trimmedFullname.lastIndexOf(" ") + 1);
    }
}
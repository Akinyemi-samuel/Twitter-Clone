package com.samuel.service;

import com.samuel.dto.request.PasswordRegistrationRequest;
import com.samuel.dto.request.RegistrationRequest;
import com.samuel.enums.Role;
import com.samuel.exception.ApiRequest;
import com.samuel.model.User;
import com.samuel.repository.UserMetadataRepository;
import com.samuel.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class RegistrationServiceTest {

    @MockBean
    private UserRepository userRepository;
    @InjectMocks
    private RegistrationService registrationService;
    @MockBean
    private UserMetadataRepository userMetadataRepository;
    @MockBean
    private IsEmailValid isemailValid;
    @MockBean
    private EmailService emailService;
    @MockBean
    private ConfirmationTokenService confirmationTokenService;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        registrationService = new RegistrationService(
                userRepository, userMetadataRepository, isemailValid,
                emailService, confirmationTokenService, passwordEncoder
        );
    }

    @Test
    void registration_SuccessfulRegistration_ReturnsToken() {
        //given
        HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);

        RegistrationRequest registrationRequest = new RegistrationRequest(
                "Akinyemi samuel",
                "samuel@gmail.com",
                "19-09-2002"
        );

        when(userRepository.findByEmail(registrationRequest.email())).thenReturn(Optional.empty());
        when(isemailValid.test(registrationRequest.email())).thenReturn(true);

        User user = User.builder()
                .userId(100L)
                .fullname(registrationRequest.fullName())
                .email(registrationRequest.email())
                .role(Role.USER)
                .registrationDate(LocalDateTime.now())
                .build();
        when(userRepository.saveAndFlush(user)).thenReturn(user);

        emailService.send(user.getEmail(), emailService.buildEmail(user.getFullname(), "hello"));

        String token = "registration_token";
        doReturn(token).when(confirmationTokenService).createConfirmationToken(any());

        // When
        String result = registrationService.registration(registrationRequest, httpServletRequest);

        // Then
        assertEquals(token, result);

//        // Ensure that userRepository.findByEmail is called once
        verify(userRepository, times(1)).findByEmail(registrationRequest.email());
//        // Ensure that emailService.send is called once
        verify(emailService, times(1)).send(user.getEmail(), emailService.buildEmail(user.getFullname(), "hello"));
//        // Ensure that userRepository.saveAndFlush is called once
        verify(userRepository, times(1)).saveAndFlush(any());
//        // Ensure that userMetadataRepository.save is called once
        verify(userMetadataRepository, times(1)).save(any());
//        // Ensure that confirmationTokenService.createConfirmationToken is called once
        verify(confirmationTokenService, times(1)).createConfirmationToken(any());

    }

    @Test
    void registration_InvalidEmail_ThrowsApiRequest() {
        //given
        RegistrationRequest registrationRequest = new RegistrationRequest(
                "Akinyemi samuel",
                "samuel@gmail.com",
                "19-09-2002"
        );

        when(userRepository.findByEmail(registrationRequest.email())).thenReturn(Optional.empty());
        when(isemailValid.test(registrationRequest.email())).thenReturn(false);

        //when and then
        assertThatThrownBy(() -> registrationService.registration(registrationRequest, any()))
                .isInstanceOf(ApiRequest.class)
                .hasMessageContaining("EMAIL INVALID");

        verify(userRepository, times(1)).findByEmail(registrationRequest.email());
        verify(isemailValid, times(1)).test(registrationRequest.email());
        verify(userRepository, never()).saveAndFlush(any());
        verify(userMetadataRepository, never()).save(any());
    }

    @Test
    void passwordRegistration() {
        //given
        User user = new User(
                100L, "samuelayo@gmail.com",
                "Akinyemi samuel", LocalDateTime.now(),
                null,
                Role.USER);

        String token = "password_registration";
        PasswordRegistrationRequest passwordRegistrationRequest = new PasswordRegistrationRequest("samuel");
        when(confirmationTokenService.getUserByToken(token)).thenReturn(user);

        //when
        String result = registrationService.passwordRegistration(token, passwordRegistrationRequest);
        Long userId = confirmationTokenService.getUserByToken(token).getUserId();

        assertEquals("Password Updated Successfully", result);

        //then
        verify(confirmationTokenService, times(2)).getUserByToken(token);
        verify(userRepository, times(1)).updatePasswordById(userId, passwordEncoder.encode(passwordRegistrationRequest.password()));
    }

    @Test
    void password_PasswordTooShort_Registration() {
        //given password is too short
        String token = "password_registration";
        PasswordRegistrationRequest passwordRegistrationRequest = new PasswordRegistrationRequest("pass");

        //when
        assertThrows(ApiRequest.class, ()-> registrationService.passwordRegistration(token, passwordRegistrationRequest));
        //then
        verify(confirmationTokenService, never()).getUserByToken(token);
        verify(userRepository, never()).updatePasswordById(anyLong(), passwordEncoder.encode(passwordRegistrationRequest.password()));
    }
}
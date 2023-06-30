package com.samuel.controller;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.dto.request.RegistrationRequest;
import com.samuel.service.AuthenticationService;
import com.samuel.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("API/V1/USERS")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/REGISTRATION")
    public String RegisterUser(@Valid @RequestBody RegistrationRequest registrationRequest, HttpServletRequest httpServletRequest){
        return registrationService.registration(registrationRequest, httpServletRequest);
    }


}

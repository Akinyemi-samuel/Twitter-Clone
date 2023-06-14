package com.samuel.controller;

import com.samuel.dto.request.RegistrationRequest;
import com.samuel.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API/V1/USERS")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String RegisterUser(@RequestBody RegistrationRequest registrationRequest){
        return registrationService.registration(registrationRequest);
    }
}

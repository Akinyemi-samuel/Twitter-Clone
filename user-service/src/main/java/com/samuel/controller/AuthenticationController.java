package com.samuel.controller;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("API/V1/USERS")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/LOGIN")
    public String login(@RequestBody AuthenticationRequest request) {
        return authenticationService.login(request);
    }


}

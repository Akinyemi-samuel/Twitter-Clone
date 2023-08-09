package com.samuel.controller;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.dto.response.AuthenticationResponse;
import com.samuel.service.AuthenticationService;
import com.samuel.util.AuthenticationUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("API/V1/AUTH")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/LOGIN")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authenticationService.login(request);
    }

}

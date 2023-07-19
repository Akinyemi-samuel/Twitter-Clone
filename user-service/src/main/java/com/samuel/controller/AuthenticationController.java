package com.samuel.controller;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.dto.response.AuthenticationResponse;
import com.samuel.model.User;
import com.samuel.service.AuthenticationService;
import com.samuel.util.AuthenticationUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;


@RestController
@RequestMapping("API/V1/AUTH")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    //private final AuthenticationUtil authenticationUtil;

    @PostMapping("/LOGIN")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authenticationService.login(request);
    }

//    @GetMapping("ID")
//    public Long getAuthenticatedUserIds(){
//        return authenticationUtil.getAuthenticatedUserId();
//    }

}

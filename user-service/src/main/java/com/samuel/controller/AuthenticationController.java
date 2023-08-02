package com.samuel.controller;

import com.samuel.dto.request.AuthenticationRequest;
import com.samuel.dto.response.AuthenticationResponse;
import com.samuel.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("API/V1/AUTH")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
   // private final AuthenticationUtil authenticationUtil;


    @PostMapping("/LOGIN")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authenticationService.login(request);
    }

//    @GetMapping("ID")
//    public Long getAuthenticatedUserIds(){
//        return authenticationUtil.getAuthenticatedUserId();
//    }

}

package com.samuel.controller;

import com.samuel.service.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("API/V1/REGISTRATION")
@AllArgsConstructor
public class ConfirmationTokenController {

    public final ConfirmationTokenService confirmationTokenService;

    @GetMapping("confirm")
    public String getConfirmationToken(@RequestParam(value="token")String token ){
        return confirmationTokenService.confirmToken(token);
    }
}

package com.samuel.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("API/V1/USERS")
@AllArgsConstructor
public class UserController {

    @GetMapping("me")
    public String getAuthenticatedUser() {
        return "worked";
    }

}
package com.samuel.controller;

import com.samuel.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("API/V1/USERS")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("me")
    public String getAuthenticatedUser() {
        return "worked";
    }

    @GetMapping("ID/{email}")
    public Long getUserIdByEmail(@PathVariable("email") String email){
        return userService.getUserIdByEmail(email);
    }

}
package com.samuel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "user-service"
)
public interface UserClients {

    @GetMapping(path = "API/V1/AUTH/USERBYEMAIL/{email}")
    public Long USERBYEMAIL(@PathVariable("email") String email);
}

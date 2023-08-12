package com.samuel.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {
    public static final List<String> openApiEndpoints = List.of(
            "API/V1/AUTH/LOGIN",
            "API/V1/AUTH/REGISTRATION",
            "API/V1/AUTH/REGISTRATION/confirm"
    );

    //Returns True if none of the httpRequest does not match the openApiEndpoints
    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}

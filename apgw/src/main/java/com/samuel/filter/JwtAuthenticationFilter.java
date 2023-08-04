package com.samuel.filter;

import com.google.common.net.HttpHeaders;
import com.samuel.util.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {


    private RouterValidator validator;
    private JwtService jwtService;
    private RestTemplate restTemplate;

    @Autowired
    public JwtAuthenticationFilter(RestTemplate restTemplate, JwtService jwtService, RouterValidator validator) {
        super(Config.class);
        this.restTemplate = restTemplate;
        this.jwtService = jwtService;
        this.validator = validator;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }

                try {
                    jwtService.validateToken(authHeader);
                    String userEmail = jwtService.extractUserName(authHeader);
                    Long userId = restTemplate.getForObject(
                            "http://localhost:8083/API/V1/USER/ID/{email}",
                            Long.class,
                            userEmail
                    );
                    exchange.getRequest()
                            .mutate()
                            .header("USER_ID_HEADER", String.valueOf(userId))
                            .build();

                } catch (Exception e) {
                    System.out.println("invalid access...!" +
                            e);
                    throw new RuntimeException("un authorized access to application");
                }

            }
            return chain.filter(exchange);
        });
    }

    public static class Config {
    }
}

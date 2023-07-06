package com.samuel.dto.response;

import lombok.Builder;

@Builder
public record AuthenticationResponse (String token) {
}

package com.samuel.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(

        @NotBlank(message = "Full name required")
        @Size(min = 4, max = 50, message = "FullName must be at least 4 characters Long and at least 50 characters Short")
        String fullName,

        @Email(regexp = ".+@.+\\..+", message = "EMAIL_NOT_VALID")
        String email,

        String dateOfBirth
) {
}

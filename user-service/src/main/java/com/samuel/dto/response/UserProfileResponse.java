package com.samuel.dto.response;

import java.time.LocalDateTime;

public record UserProfileResponse(

        String fullname,

        String bio,

        String username,

        String phone,

        String website,

        String location,

        String profile_image,

        String banner_image,

        String country,

        String language,

        boolean verified,

        LocalDateTime registrationDate,

        LocalDateTime UpdatedAt

        ) {
}

INSERT INTO users (user_id, updated_at, banner_image, bio, country, country_code, email, fullname, gender,
  `language`, location, password, phone, profile_image, registration_date, `role`, username,
   verified, website)
VALUES(101, '2010-11-11 00:00:00', NULL,'21|👩‍💻Java | 🍃Spring | 🏋️Gym | Full-Stack developer',
   'nigeria', '+234', 'samuel@gmail.com', 'Akinyemi samuel', 'MALE', NULL, 'lagos',
    '$2a$10$HO1lD/hREJsFyVQe8x6dcuMG/6P8JIIOyQNC89CCTQ0h8sGjQ7bfO', NULL, NULL,
     '2023-07-06 21:31:38', 'USER', 'samfrosh', 1, 'https://github.com/Akinyemi-samuel');

INSERT INTO confirmation_token (id, token, created_at, confirmed_at, expires_at, user_id)
VALUES (100, '2404045f-8434-43a8-b05b-9f6003e72ec0', '2023-07-06 21:31:39',
 null, '2023-07-06 21:46:39', 100 );

INSERT INTO user_metadata  (id, birth_date, user_id)
VALUES (50, '09-09-2002', 100 );
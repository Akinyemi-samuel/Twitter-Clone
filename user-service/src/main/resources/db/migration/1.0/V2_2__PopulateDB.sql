INSERT INTO users (user_id, email, fullname, registration_date, password, `role`)
VALUES (100, 'samuel@gmail.com', 'Akinyemi samuel', '2023-07-06 21:31:38', '$2a$10$HO1lD/hREJsFyVQe8x6dcuMG/6P8JIIOyQNC89CCTQ0h8sGjQ7bfO', 'USER' );

INSERT INTO confirmation_token (id, token, created_at, confirmed_at, expires_at, user_id)
VALUES (100, '2404045f-8434-43a8-b05b-9f6003e72ec0', '2023-07-06 21:31:39', null, '2023-07-06 21:46:39', 100 );

INSERT INTO user_metadata  (id, birth_date, user_id)
VALUES (50, '09-09-2002', 100 );
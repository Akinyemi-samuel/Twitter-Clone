INSERT INTO user (user_id, email, fullname, registration_date, password, `role`)
VALUES (99, "samuel@gmail.com", "Akinyemi samuel", "2023-07-06 21:31:38", "$2a$10$zlWBow4Jrp0git8yKgnAMOFxXb2ojqXr9q7wW3nD0D5GZgGc0wec2", "USER" );

INSERT INTO confirmation_token (id, token, created_at, confirmed_at, expires_at, user_id)
VALUES (100, "2404045f-8434-43a8-b05b-9f6003e72ec0", "2023-07-06 21:31:39", null, "2023-07-06 21:46:39", 99 );

INSERT INTO user_metadata  (id, birth_date, user_id)
VALUES (50, "09-09-2002", 99 );
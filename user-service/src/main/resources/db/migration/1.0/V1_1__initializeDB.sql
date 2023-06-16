CREATE TABLE follower (
  id BIGINT NOT NULL,
   follower_id BIGINT DEFAULT NULL NULL,
   user_id BIGINT DEFAULT NULL NULL,
   CONSTRAINT PK_FOLLOWER PRIMARY KEY (id)
);

CREATE TABLE follower_seq (
  next_val BIGINT DEFAULT NULL NULL
);

CREATE TABLE user (
  user_id BIGINT NOT NULL,
   updated_at datetime DEFAULT NULL NULL,
   banner_image VARCHAR(255) NULL,
   bio VARCHAR(255) NULL,
   country VARCHAR(255) NULL,
   country_code VARCHAR(255) NULL,
   email VARCHAR(255) NULL,
   fullname VARCHAR(255) NOT NULL,
   gender VARCHAR(255) NULL,
   language VARCHAR(255) NULL,
   location VARCHAR(255) NULL,
   password VARCHAR(255) NULL,
   phone VARCHAR(255) NULL,
   profile_image VARCHAR(255) NULL,
   registration_date datetime DEFAULT NULL NULL,
   `role` VARCHAR(255) NULL,
   username VARCHAR(255) NULL,
   verified BIT DEFAULT 0 NULL,
   website VARCHAR(255) NULL,
   CONSTRAINT PK_USER PRIMARY KEY (user_id),
   UNIQUE (email),
   UNIQUE (phone)
);

CREATE TABLE user_activity (
  id BIGINT NOT NULL,
   last_login_at datetime DEFAULT NULL NULL,
   status VARCHAR(255) NULL,
   user_id BIGINT DEFAULT NULL NULL,
   CONSTRAINT PK_USER_ACTIVITY PRIMARY KEY (id)
);

CREATE TABLE user_activity_seq (
  next_val BIGINT DEFAULT NULL NULL
);

CREATE TABLE user_confirmation (
  id BIGINT NOT NULL,
   email_confirmed BIT DEFAULT 0 NULL,
   phone_confirmed BIT DEFAULT 0 NULL,
   user_id BIGINT DEFAULT NULL NULL,
   CONSTRAINT PK_USER_CONFIRMATION PRIMARY KEY (id)
);

CREATE TABLE user_confirmation_seq (
  next_val BIGINT DEFAULT NULL NULL
);

CREATE TABLE user_metadata (
  id BIGINT NOT NULL,
   birth_date VARCHAR(255) NULL,
   education BIGINT DEFAULT NULL NULL,
   gender BIGINT DEFAULT NULL NULL,
   interests BIGINT DEFAULT NULL NULL,
   occupation VARCHAR(255) NULL,
   user_id BIGINT DEFAULT NULL NULL,
   CONSTRAINT PK_USER_METADATA PRIMARY KEY (id)
);

CREATE TABLE user_metadata_seq (
  next_val BIGINT DEFAULT NULL NULL
);

CREATE TABLE user_seq (
  next_val BIGINT DEFAULT NULL NULL
);

CREATE TABLE user_statistics (
  id BIGINT NOT NULL,
   favorite_count BIGINT DEFAULT NULL NULL,
   followers_count BIGINT DEFAULT NULL NULL,
   following_count BIGINT DEFAULT NULL NULL,
   likes_count BIGINT DEFAULT NULL NULL,
   retweets_count BIGINT DEFAULT NULL NULL,
   tweet_count BIGINT DEFAULT NULL NULL,
   user_id BIGINT DEFAULT NULL NULL,
   CONSTRAINT PK_USER_STATISTICS PRIMARY KEY (id)
);

CREATE TABLE user_statistics_seq (
  next_val BIGINT DEFAULT NULL NULL
);

CREATE INDEX FK2tkyv0rmjw4t203ipp5tdob4a ON follower(follower_id);

CREATE INDEX FK8gkt7sisluv65lbbmt0xei6nf ON user_metadata(user_id);

CREATE INDEX FKcavkglmb1xvi6eolpcx98nxcj ON user_confirmation(user_id);

CREATE INDEX FKp78clcyf5okycdv9teohsr2kq ON user_activity(user_id);

CREATE INDEX FKpt8rurq22vf5732sa75jhm0kb ON user_statistics(user_id);

CREATE INDEX FKr99xseniq62g6519wn3i3duak ON follower(user_id);

CREATE INDEX flyway_schema_history_s_idx ON flyway_schema_history(success);

ALTER TABLE follower ADD CONSTRAINT FK2tkyv0rmjw4t203ipp5tdob4a FOREIGN KEY (follower_id) REFERENCES user (user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE user_metadata ADD CONSTRAINT FK8gkt7sisluv65lbbmt0xei6nf FOREIGN KEY (user_id) REFERENCES user (user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE user_confirmation ADD CONSTRAINT FKcavkglmb1xvi6eolpcx98nxcj FOREIGN KEY (user_id) REFERENCES user (user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE user_activity ADD CONSTRAINT FKp78clcyf5okycdv9teohsr2kq FOREIGN KEY (user_id) REFERENCES user (user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE user_statistics ADD CONSTRAINT FKpt8rurq22vf5732sa75jhm0kb FOREIGN KEY (user_id) REFERENCES user (user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

ALTER TABLE follower ADD CONSTRAINT FKr99xseniq62g6519wn3i3duak FOREIGN KEY (user_id) REFERENCES user (user_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
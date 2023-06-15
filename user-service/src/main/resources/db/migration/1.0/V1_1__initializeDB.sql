CREATE TABLE follower (
  id BIGINT NOT NULL,
   user_id BIGINT NULL,
   follower_id BIGINT NULL,
   CONSTRAINT pk_follower PRIMARY KEY (id)
);

CREATE TABLE user (
  user_id BIGINT NOT NULL,
   fullname VARCHAR(255) NOT NULL,
   bio VARCHAR(255) NULL,
   username VARCHAR(255) NULL,
   phone VARCHAR(255) NULL,
   email VARCHAR(255) NULL,
   password VARCHAR(255) NULL,
   gender VARCHAR(255) NULL,
   website VARCHAR(255) NULL,
   location VARCHAR(255) NULL,
   profile_image VARCHAR(255) NULL,
   banner_image VARCHAR(255) NULL,
   country VARCHAR(255) NULL,
   country_code VARCHAR(255) NULL,
   `role` VARCHAR(255) NULL,
   language VARCHAR(255) NULL,
   verified BIT(1) NULL,
   registration_date datetime NULL,
   updated_at datetime NULL,
   CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE user_activity (
  id BIGINT NOT NULL,
   last_login_at datetime NULL,
   status VARCHAR(255) NULL,
   user_id BIGINT NULL,
   CONSTRAINT pk_user_activity PRIMARY KEY (id)
);

CREATE TABLE user_confirmation (
  id BIGINT NOT NULL,
   gender BIGINT NULL,
   education BIGINT NULL,
   interests BIGINT NULL,
   birth_date VARCHAR(255) NULL,
   occupation VARCHAR(255) NULL,
   user_id BIGINT NULL,
   CONSTRAINT pk_user_confirmation PRIMARY KEY (id)
);

CREATE TABLE user_statistics (
  id BIGINT NOT NULL,
   user_id BIGINT NULL,
   followers_count BIGINT NULL,
   following_count BIGINT NULL,
   tweet_count BIGINT NULL,
   likes_count BIGINT NULL,
   favorite_count BIGINT NULL,
   retweets_count BIGINT NULL,
   CONSTRAINT pk_user_statistics PRIMARY KEY (id)
);

CREATE TABLE user_metadata (
  id BIGINT NOT NULL,
   gender BIGINT NULL,
   education BIGINT NULL,
   interests BIGINT NULL,
   birth_date VARCHAR(255) NULL,
   occupation VARCHAR(255) NULL,
   user_id BIGINT NULL,
   CONSTRAINT pk_user_metadata PRIMARY KEY (id)
);

ALTER TABLE user_metadata ADD CONSTRAINT FK_USER_METADATA_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE user ADD CONSTRAINT email UNIQUE (email);

ALTER TABLE user ADD CONSTRAINT phone UNIQUE (phone);

ALTER TABLE follower ADD CONSTRAINT FK_FOLLOWER_ON_FOLLOWER FOREIGN KEY (follower_id) REFERENCES user (user_id);

ALTER TABLE follower ADD CONSTRAINT FK_FOLLOWER_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE user_activity ADD CONSTRAINT FK_USER_ACTIVITY_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE user_confirmation ADD CONSTRAINT FK_USER_CONFIRMATION_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE user_statistics ADD CONSTRAINT FK_USER_STATISTICS_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);
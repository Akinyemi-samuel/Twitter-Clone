CREATE TABLE confirmation_token (
  id BIGINT NOT NULL,
   token VARCHAR(255) NULL,
   created_at datetime NULL,
   expires_at datetime NULL,
   confirmed_at datetime NULL,
   user_id BIGINT NULL,
   CONSTRAINT PK_CONFIRMATION_TOKEN PRIMARY KEY (id)
);

CREATE TABLE confirmation_token_seq (
  next_val BIGINT NULL
);

CREATE TABLE follower (
  id BIGINT NOT NULL,
   follower_id BIGINT NULL,
   user_id BIGINT NULL,
   CONSTRAINT PK_FOLLOWER PRIMARY KEY (id)
);

CREATE TABLE follower_seq (
  next_val BIGINT NULL
);

CREATE TABLE user (
  user_id BIGINT NOT NULL,
   updated_at datetime NULL,
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
   registration_date datetime NULL,
   `role` VARCHAR(255) NULL,
   username VARCHAR(255) NULL,
   verified BIT(1) DEFAULT 0 NULL,
   website VARCHAR(255) NULL,
   CONSTRAINT PK_USER PRIMARY KEY (user_id),
   UNIQUE (email),
   UNIQUE (phone)
);

CREATE TABLE user_activity (
  id BIGINT NOT NULL,
   last_login_at datetime NULL,
   status VARCHAR(255) NULL,
   user_id BIGINT NULL,
   CONSTRAINT PK_USER_ACTIVITY PRIMARY KEY (id)
);

CREATE TABLE user_activity_seq (
  next_val BIGINT NULL
);

CREATE TABLE user_confirmation (
  id BIGINT NOT NULL,
   email_confirmed BIT(1) DEFAULT 0 NULL,
   phone_confirmed BIT(1) DEFAULT 0 NULL,
   user_id BIGINT NULL,
   CONSTRAINT PK_USER_CONFIRMATION PRIMARY KEY (id)
);

CREATE TABLE user_confirmation_seq (
  next_val BIGINT NULL
);

CREATE TABLE user_metadata (
  id BIGINT NOT NULL,
   birth_date VARCHAR(255) NULL,
   education BIGINT NULL,
   gender BIGINT NULL,
   interests BIGINT NULL,
   occupation VARCHAR(255) NULL,
   user_id BIGINT NULL,
   CONSTRAINT PK_USER_METADATA PRIMARY KEY (id)
);

CREATE TABLE user_metadata_seq (
  next_val BIGINT NULL
);

CREATE TABLE user_seq (
  next_val BIGINT NULL
);

CREATE TABLE user_statistics (
  id BIGINT NOT NULL,
   favorite_count BIGINT NULL,
   followers_count BIGINT NULL,
   following_count BIGINT NULL,
   likes_count BIGINT NULL,
   retweets_count BIGINT NULL,
   tweet_count BIGINT NULL,
   user_id BIGINT NULL,
   CONSTRAINT PK_USER_STATISTICS PRIMARY KEY (id)
);

CREATE TABLE user_statistics_seq (
  next_val BIGINT NULL
);
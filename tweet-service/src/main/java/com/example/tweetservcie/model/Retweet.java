package com.example.tweetservcie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "re_tweet",
        indexes = {
                @Index(name = "re_tweets_user_id_index", columnList = "user_id"),
                @Index(name = "re_tweets_tweet_id_index", columnList = "tweet_id"),
        }
)
public class Retweet {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "retweet_generator"
    )
    @SequenceGenerator(
            sequenceName = "retweet_seq",
            name = "retweet_seq"
    )
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "tweet_id")
    private Long tweetId;

    @Column(name = "retweet_date")
    private LocalDateTime reTweetDate =LocalDateTime.now();
}

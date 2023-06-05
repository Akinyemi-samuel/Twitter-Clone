package com.samuel.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "user_statistics")
public class UserStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "followers_count")
    private Long followersCount = 0L;

    @Column(name = "following_count")
    private Long followingCount = 0L;

    @Column(name = "tweet_count")
    private Long tweetCount = 0L;

    @Column(name = "likes_count")
    private Long likesCount = 0L;

    @Column(name = "favorite_count")
    private Long favoriteCount = 0L;

    @Column(name = "retweets_count")
    private Long retweetsCount = 0L;


}

package com.example.tweetservcie.model;

import com.example.tweetservcie.enums.ReplyAccessibility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(
        name = "tweet",
        indexes = @Index(
                name = "tweet_user_id_index", columnList = "user_id"
        )
)

public class Tweet {

    @Id
    @SequenceGenerator(
            name = "tweet_sequence",
            sequenceName = "tweet_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tweet_sequence"
    )
    private Long id;

    @Column(name = "content", length = 5000, nullable = false)
    private String content;

    @Column(name = "timestamp")
    private LocalDateTime timestamp = LocalDateTime.now();

    @Column(name = "user_id", nullable = false)
    private Long user;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted = false;

    @Column(name = "reply_type")
    @Enumerated(EnumType.STRING)
    private ReplyAccessibility replyType = ReplyAccessibility.EVERYONE;

    @Column(name = "image_description")
    private String imageDescription;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany
    private List<TweetImage> tweetImage;


}

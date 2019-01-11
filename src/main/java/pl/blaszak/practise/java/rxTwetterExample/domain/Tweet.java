package pl.blaszak.practise.java.rxTwetterExample.domain;

import java.time.LocalDateTime;

public class Tweet {

    private final LocalDateTime createdAt;
    private final Long userId;
    private final String title;
    private final String body;

    public Tweet(LocalDateTime createdAt, Long userId, String title, String body) {
        this.createdAt = createdAt;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "createdAt=" + createdAt +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

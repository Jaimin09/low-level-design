package entity;

import lombok.Getter;
import model.User;

import java.time.Instant;
import java.util.UUID;

@Getter
public class Comment {
    String commentId;
    String content;
    User user;
    Instant creationTimestamp;

    public Comment(String content, User user) {
        this.commentId = UUID.randomUUID().toString();
        this.content = content;
        this.user = user;
        this.creationTimestamp = Instant.now();
    }
}

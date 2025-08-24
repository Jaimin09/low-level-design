package entity;

import lombok.Getter;
import model.User;
import model.VoteType;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Post {
    String id;
    List<Comment> comments;
    Map<String, VoteType> votes;
    AtomicInteger voteCount;
    User author;
    Instant creationTimestamp;
    String content;
    List<String> tags;

    public Post(User author, String content, List<String> tags) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.creationTimestamp = Instant.now();
        this.comments = new ArrayList<>();
        this.votes = new HashMap<>();
        this.voteCount = new AtomicInteger(0);
        this.content = content;
        this.tags = tags;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addVote(String userId, VoteType voteType) {
        // vote already present
        if (Objects.equals(votes.get(userId), voteType))
            return;

        // User changing the vote
        int changeVoteCount = 0;
        if (votes.get(userId) != null) {
            changeVoteCount = voteType == VoteType.UPVOTE ? 2 : -2;
        } else {
            changeVoteCount = voteType == VoteType.UPVOTE ? 1 : -1;
        }

        voteCount.addAndGet(changeVoteCount);
    }

    public int getVoteCount() {
        return voteCount.get();
    }

}

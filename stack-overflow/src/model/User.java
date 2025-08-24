package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class User {
    private String userId;
    private int score;

    public User(String userId){
        this.userId = userId;
        this.score = 0;
    }
}

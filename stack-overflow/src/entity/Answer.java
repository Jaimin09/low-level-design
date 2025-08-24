package entity;

import lombok.Setter;
import model.User;

import java.util.List;

public class Answer extends Post {
    @Setter
    boolean acceptedAnswer;

    public Answer(User user, String content, List<String> tags) {
        super(user, content, tags);
    }
}

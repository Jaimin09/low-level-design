package entity;

import model.User;

import java.util.List;

public class Question extends Post{
    String title;
    List<Answer> answer;

    public Question(User user, String content, String title, List<String> tags) {
        super(user, content, tags);
        this.title = title;
    }

    public void addAnswer(Answer answer){
        this.answer.add(answer);
    }
}

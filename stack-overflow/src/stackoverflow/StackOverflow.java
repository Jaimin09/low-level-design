package stackoverflow;

import entity.Answer;
import entity.Comment;
import entity.Post;
import entity.Question;
import model.User;
import model.VoteType;
import reputation.UserReputationManager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflow {
    private static StackOverflow instance;
    Map<String, Question> questions;
    Map<String, Answer> answers;
    Map<String, User> users;
    UserReputationManager userReputationManager;

    private StackOverflow(UserReputationManager userReputationManager){
       this.questions = new ConcurrentHashMap<>();
       this.answers = new ConcurrentHashMap<>();
       this.users = new ConcurrentHashMap<>();
       this.userReputationManager = userReputationManager;
    }

    public static synchronized StackOverflow getInstance(){
        if(instance == null){
            instance = new StackOverflow(new UserReputationManager());
        }
        return instance;
    }

    public void addUser(String userId){
        users.put(userId, new User(userId));
    }

    public String addQuestion(String userId, String title, String content, List<String> tags){
        User user = findUserById(userId);
        Question question = new Question(user, content, title, tags);
        questions.put(question.getId(), question);
        return question.getId();
    }

    public String addAnswer(String userId, String content, List<String> tags){
        User user = findUserById(userId);
        Answer answer = new Answer(user, content, tags);
        answers.put(answer.getId(), answer);
        return answer.getId();
    }

    public void addComment(String postId, String userId, String content) {
        User user = findUserById(userId);
        Post post = findPostById(postId);
        Comment comment = new Comment(content, user);
        post.addComment(comment);
    }

    public void addVote(String userId, String postId, VoteType voteType) {
        Post post = findPostById(postId);
        post.addVote(userId, voteType);
    }

    public int getVotes(String postId) {
        Post post = findPostById(postId);
        return post.getVoteCount();
    }

    private Post findPostById(String postId) {
        Post questionPost = questions.get(postId);
        Post answerPost = answers.get(postId);

        if (questionPost == null &&  answerPost == null) {
            throw new RuntimeException("post not found with id " + postId);
        }
        return questionPost != null ? questionPost : answerPost;
    }

    private User findUserById(String userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new RuntimeException("user not found with id " + userId);
        }
        return user;
    }

}

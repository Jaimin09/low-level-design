import model.User;
import model.VoteType;
import stackoverflow.StackOverflow;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        stackOverflow.addUser("alice");
        stackOverflow.addUser("bob");

        String questionId = stackOverflow.addQuestion("alice", "What is StackOverflow", "Idk", Arrays.asList("stack", "overflow"));
        String answerId = stackOverflow.addAnswer("bob", "It's a great tool", Collections.emptyList());

        stackOverflow.addVote("alice", answerId, VoteType.UPVOTE);
        stackOverflow.addVote("bob", answerId, VoteType.UPVOTE);

        System.out.println("Votes on the answer: " + answerId + " is: " + stackOverflow.getVotes(answerId));
    }
}
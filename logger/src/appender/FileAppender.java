package appender;

public class FileAppender implements Appender {
    @Override
    public void append(String message) {
        System.out.println("FILE: " + message);
    }
}

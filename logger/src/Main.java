import appender.ConsoleAppender;
import appender.FileAppender;
import model.LogLevel;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        LogConfig.addAppender(LogLevel.INFO, new ConsoleAppender());
        LogConfig.addAppender(LogLevel.ERROR, new ConsoleAppender());
        LogConfig.addAppender(LogLevel.ERROR, new FileAppender());

        Thread t1 = new Thread(() -> {logger.info("Hello world");});
        Thread t2 = new Thread(() -> {logger.error("Oops, error");});

        t2.start();
        t1.start();
    }
}

// Strategy pattern in Handlers
// Observer pattern in Appender
// Config class which statically loads the configurations & gives that static config to Logger

// logger.info() -> logger.log(INFO, msg) -> InfoHandler -> notifyAppenders -> appender -> formatter
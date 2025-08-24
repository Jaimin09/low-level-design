import handler.LogHandler;
import model.LogLevel;
import model.LogMessage;

import java.time.Instant;
import java.util.Map;

public class Logger {
    private static Logger instance;
    Map<LogLevel, LogHandler> logHandlerMap;

    private Logger() {
        this.logHandlerMap = LogConfig.getHandlers();
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(LogLevel level, String message) {
        LogMessage logMessage = new LogMessage(message, Instant.now(), level);
        LogHandler logHandler = logHandlerMap.get(level);
        logHandler.log(logMessage);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}

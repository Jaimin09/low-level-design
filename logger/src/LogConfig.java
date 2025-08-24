import appender.Appender;
import formatter.SimpleTextFormatter;
import handler.ErrorHandler;
import handler.InfoHandler;
import handler.LogHandler;
import model.LogLevel;

import java.util.HashMap;
import java.util.Map;

public class LogConfig {

    private static Map<LogLevel, LogHandler> handlers = new HashMap<>();

    static {
        handlers.put(LogLevel.INFO, new InfoHandler(new SimpleTextFormatter()));
        handlers.put(LogLevel.ERROR, new ErrorHandler(new SimpleTextFormatter()));
    }

    public static Map<LogLevel, LogHandler> getHandlers() {
        return handlers;
    }

    public static void addAppender(LogLevel level, Appender appender) {
        handlers.get(level).subscribe(appender);
    }
}

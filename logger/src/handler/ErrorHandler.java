package handler;

import formatter.LogFormatter;
import model.LogLevel;

public class ErrorHandler extends LogHandler {

    public ErrorHandler(LogFormatter formatter) {
        super(LogLevel.ERROR, formatter);
    }
}

package handler;


import formatter.LogFormatter;
import formatter.SimpleTextFormatter;
import model.LogLevel;

import java.util.ArrayList;

public class InfoHandler extends LogHandler {
    public InfoHandler(LogFormatter formatter) {
        super(LogLevel.INFO, formatter);
    }
}

package handler;

import appender.Appender;
import formatter.LogFormatter;
import model.LogLevel;
import model.LogMessage;

import java.util.ArrayList;
import java.util.List;

public class LogHandler {
    List<Appender> appenders;
    LogFormatter formatter;
    LogLevel level;

    LogHandler(LogLevel level, LogFormatter formatter) {
        this.formatter = formatter;
        this.appenders =  new ArrayList<>();
        this.level = level;
    }

    public void log(LogMessage message) {
        String formattedMsg = formatter.format(message);
        notifyAppenders(formattedMsg);
    }

    void notifyAppenders(String formattedMsg) {
        for (Appender appender : appenders) {
            appender.append(formattedMsg);
        }
    }

    public void subscribe(Appender appender) {
        appenders.add(appender);
    }

}

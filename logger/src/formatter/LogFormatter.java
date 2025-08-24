package formatter;

import model.LogLevel;
import model.LogMessage;

public interface LogFormatter {
    public String format(LogMessage message);
}

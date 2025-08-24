package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class LogMessage {
    String message;
    Instant timestamp;
    LogLevel level;
}

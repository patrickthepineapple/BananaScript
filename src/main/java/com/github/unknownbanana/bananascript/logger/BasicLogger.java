package com.github.unknownbanana.bananascript.logger;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class BasicLogger implements Logger{
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ss:mm:hh");

    @Override
    public void log(LogLevel logLevel, String format, Object... replacements) {
        for (var o : replacements) {
            format.replaceFirst("\\{}", o.toString());
        }
        System.out.println("[" + simpleDateFormat.format(Date.from(Instant.now())) + "] " + "[" + logLevel.name() + "] " + format);
    }

    @Override
    public void error(LogLevel logLevel, String format, Object... replacements) {
        log(logLevel, format, replacements);
        System.exit(1);
    }
}

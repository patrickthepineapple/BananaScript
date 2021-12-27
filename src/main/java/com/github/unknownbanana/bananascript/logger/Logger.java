package com.github.unknownbanana.bananascript.logger;

public interface Logger {

    void log(LogLevel logLevel, String format, Object... replacements);

    void error(LogLevel logLevel, String format, Object... replacements);
}

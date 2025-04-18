package com.lld.logger.loggerLLD.handlers;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.observer.Subject;

import java.util.logging.Handler;

public class DebugHandler extends AbstractLogger{

    public DebugHandler(LogLevel level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message, Subject subject) {
        message = "DEBUG: " + message;
        subject.notifyObservers(message);
    }
}

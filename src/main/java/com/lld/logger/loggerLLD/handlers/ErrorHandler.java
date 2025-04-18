package com.lld.logger.loggerLLD.handlers;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.observer.Subject;

public class ErrorHandler extends AbstractLogger {
    public ErrorHandler(LogLevel level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message, Subject subject) {
        String msg = "ERROR: "+ message;
        subject.notifyObservers(msg);
    }
}

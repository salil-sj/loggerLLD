package com.lld.logger.loggerLLD.handlers;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.observer.Subject;

public class InfoHandler extends AbstractLogger {

    public InfoHandler(LogLevel level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message, Subject subject) {
        message= "[INFO] "+message;
        subject.notifyObservers(message);
    }
}

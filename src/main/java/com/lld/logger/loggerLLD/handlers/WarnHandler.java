package com.lld.logger.loggerLLD.handlers;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.observer.Subject;

import java.util.logging.Handler;

public class WarnHandler extends AbstractLogger {

    public WarnHandler(LogLevel level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message, Subject subject) {
        System.out.printf("[INFO] %s\n", message);
        subject.notifyObservers(message);
    }
}

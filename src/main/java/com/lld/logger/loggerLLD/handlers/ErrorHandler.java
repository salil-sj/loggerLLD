package com.lld.logger.loggerLLD.handlers;

public class ErrorHandler extends AbstractLogger {
    public ErrorHandler(int level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message) {
        System.out.printf("ERROR: %s\n", message);
    }
}

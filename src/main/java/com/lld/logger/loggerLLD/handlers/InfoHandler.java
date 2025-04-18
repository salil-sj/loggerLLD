package com.lld.logger.loggerLLD.handlers;

public class InfoHandler extends AbstractLogger {

    public InfoHandler(int level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message) {
        System.out.printf("[INFO] %s\n", message);
    }
}

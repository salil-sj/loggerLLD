package com.lld.logger.loggerLLD.handlers;

import java.util.logging.Handler;

public class WarnHandler extends AbstractLogger {

    public WarnHandler(int level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message) {
        System.out.printf("[INFO] %s\n", message);
    }
}

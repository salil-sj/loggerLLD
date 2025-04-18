package com.lld.logger.loggerLLD.handlers;

import java.util.logging.Handler;

public class DebugHandler extends AbstractLogger{

    public DebugHandler(int level) {
        this.logLevel = level;
    }

    @Override
    public void printLogMessage(String message) {
        System.out.println("DEBUG: " + message);
    }
}

package com.lld.logger.loggerLLD;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.factory.LoggerChainFactory;
import com.lld.logger.loggerLLD.handlers.AbstractLogger;

public class Logger {

    private static Logger logger;
    private AbstractLogger loggerChain;

    private Logger() {
        this.loggerChain = LoggerChainFactory.createLoggerChain();
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void log(LogLevel logLevel, String msg) {
       this.loggerChain.log(logLevel.getLevel(),msg);
    }

    public void info(String msg) {
        log(LogLevel.INFO,msg);
    }

    public void error(String msg) {
        log(LogLevel.ERROR,msg);
    }

    public void debug(String msg) {
        log(LogLevel.DEBUG,msg);
    }
}

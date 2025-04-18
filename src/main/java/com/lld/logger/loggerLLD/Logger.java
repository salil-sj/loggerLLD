package com.lld.logger.loggerLLD;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.factory.LoggerFactory;
import com.lld.logger.loggerLLD.handlers.AbstractLogger;
import com.lld.logger.loggerLLD.observer.Subject;

public class Logger {

    private static Logger logger;
    private AbstractLogger loggerChain;
    private Subject logSubject;

    private Logger() {
        this.loggerChain = LoggerFactory.createLoggerChain();
        this.logSubject= LoggerFactory.createSubject();
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
       this.loggerChain.log(logLevel.getLevel(),msg, this.logSubject);
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

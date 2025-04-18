package com.lld.logger.loggerLLD;

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

    public void log(int logLevel,String msg) {
       this.loggerChain.log(logLevel,msg);
    }

    public void info(String msg) {
        log(1,msg);
    }

    public void error(String msg) {
        log(3,msg);
    }

    public void debug(String msg) {
        log(2,msg);
    }
}

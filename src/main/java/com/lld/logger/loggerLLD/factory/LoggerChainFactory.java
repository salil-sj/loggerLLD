package com.lld.logger.loggerLLD.factory;

import com.lld.logger.loggerLLD.handlers.AbstractLogger;
import com.lld.logger.loggerLLD.handlers.DebugHandler;
import com.lld.logger.loggerLLD.handlers.ErrorHandler;
import com.lld.logger.loggerLLD.handlers.InfoHandler;

public class LoggerChainFactory {

    public static AbstractLogger createLoggerChain() {
        AbstractLogger infoLogger = new InfoHandler(1);
        AbstractLogger debugLogger = new DebugHandler(2);
        AbstractLogger errorLogger = new ErrorHandler(3);

        infoLogger.setNextLogger(debugLogger).setNextLogger(errorLogger);
        return infoLogger;
    }
}

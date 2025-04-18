package com.lld.logger.loggerLLD.factory;

import com.lld.logger.loggerLLD.handlers.*;

public class LoggerChainFactory {

    public static AbstractLogger createLoggerChain() {
        AbstractLogger infoLogger = new InfoHandler(1);
        AbstractLogger debugLogger = new DebugHandler(2);
        AbstractLogger errorLogger = new ErrorHandler(3);
        AbstractLogger warnLogger = new WarnHandler(4);
        infoLogger.setNextLogger(debugLogger).setNextLogger(errorLogger).setNextLogger(warnLogger);
        return infoLogger;
    }
}

package com.lld.logger.loggerLLD.factory;

import com.lld.logger.loggerLLD.constants.LogLevel;
import com.lld.logger.loggerLLD.handlers.*;
import com.lld.logger.loggerLLD.observer.ConsoleObserver;
import com.lld.logger.loggerLLD.observer.FileObserver;
import com.lld.logger.loggerLLD.observer.LogSubject;
import com.lld.logger.loggerLLD.observer.Subject;

public class LoggerFactory {

    public static AbstractLogger createLoggerChain() {
        AbstractLogger infoLogger = new InfoHandler(LogLevel.INFO);
        AbstractLogger debugLogger = new DebugHandler(LogLevel.DEBUG);
        AbstractLogger errorLogger = new ErrorHandler(LogLevel.ERROR);

        infoLogger.setNextLogger(debugLogger).setNextLogger(errorLogger);
        return infoLogger;
    }

    public static Subject createSubject() {
        Subject subject= new LogSubject();
        ConsoleObserver consoleObserver = new ConsoleObserver();
        FileObserver fileObserver = new FileObserver();
        subject.registerObserver(fileObserver);
        subject.registerObserver(consoleObserver);
        return subject;
    }
}

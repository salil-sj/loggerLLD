package com.lld.logger.loggerLLD.observer;

public class ConsoleObserver implements Observer {
    @Override
    public void log(String message) {
        System.out.println("[ConsoleObserver] " + message);
    }
}

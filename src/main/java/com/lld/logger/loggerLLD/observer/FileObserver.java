package com.lld.logger.loggerLLD.observer;

public class FileObserver implements Observer {

    @Override
    public void log(String message) {
        System.out.println("[Fileobserver] " + message);
    }
}

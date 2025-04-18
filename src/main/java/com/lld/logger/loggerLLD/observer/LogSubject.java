package com.lld.logger.loggerLLD.observer;

import java.util.ArrayList;
import java.util.List;


public class LogSubject implements Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        observers.stream().forEach(observer-> observer.log(message));
    }
}

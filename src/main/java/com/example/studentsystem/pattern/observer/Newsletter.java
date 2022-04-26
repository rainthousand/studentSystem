package com.example.studentsystem.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Newsletter implements Subject {
    private List<Observer> SubscriberStudentList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        SubscriberStudentList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        SubscriberStudentList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer subscriber : SubscriberStudentList) {
            subscriber.update(message);
        }
    }
}

package com.example.studentsystem.pattern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NewsSubject implements Subject {

    private List<Observer> SubscriberStudentList = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        SubscriberStudentList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        SubscriberStudentList.remove(observer);
    }

    public void setSubscriberStudentList(List<Observer> subscriberStudentList) {
        SubscriberStudentList = subscriberStudentList;
    }

    public List<Observer> getSubscriberStudentList() {
        return SubscriberStudentList;
    }

    @Override
    public List<List<Integer>> publishAndNotify(Integer newsid) {
//        HashMap<Integer,Integer> KeyMap=new HashMap<>();
        List<List<Integer>> KeyList=new ArrayList<>();
        for (Observer subscriber : SubscriberStudentList) {
            List<Integer> stuKeyList = subscriber.update(newsid);
            KeyList.add(stuKeyList);
        }
        return KeyList;
    }

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

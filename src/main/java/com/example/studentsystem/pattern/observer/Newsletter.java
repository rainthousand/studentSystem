package com.example.studentsystem.pattern.observer;

import com.example.studentsystem.service.NewsletterService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class Newsletter implements Subject {
    @Resource(name = "newsletterServiceImpl")
    private NewsletterService newsletterService;

    private List<Observer> SubscriberStudentList = new ArrayList<Observer>();
    private Integer newsID;
    private String subject;

    public Newsletter(Integer newsID, String subject) {
        this.newsID = newsID;
        this.subject = subject;
    }

    public Newsletter(List<Observer> SubscriberStudentList) {
        this.SubscriberStudentList = SubscriberStudentList;
    }

    @Override
    public void attach(Observer observer) {
        SubscriberStudentList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        SubscriberStudentList.remove(observer);
    }

    @Override
    public void notifySubscription() {
        for (Observer subscriber : SubscriberStudentList) {
            subscriber.update(newsID);
        }
    }
}

package com.example.studentsystem.pattern.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsletterOb implements Subject {

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

    @Override
    public void notifySubscription() {
        for (Observer subscriber : SubscriberStudentList) {
            subscriber.update(newsid);
        }
    }

    private Integer newsid;
    private String newsname;
    private String publisher;
    private String subject;
    private String newsmessage;
    private Date publishtime;
    private Integer newstype;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewsname() {
        return newsname;
    }

    public void setNewsname(String newsname) {
        this.newsname = newsname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNewsmessage() {
        return newsmessage;
    }

    public void setNewsmessage(String newsmessage) {
        this.newsmessage = newsmessage;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getNewstype() {
        return newstype;
    }

    public void setNewstype(Integer newstype) {
        this.newstype = newstype;
    }
}

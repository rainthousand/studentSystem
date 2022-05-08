package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.*;
import com.example.studentsystem.mapper.NewsLetterMapper;
import com.example.studentsystem.mapper.NewsSubjectMapper;
import com.example.studentsystem.mapper.SubscribedNewsletterMapper;
import com.example.studentsystem.mapper.SubscribedSubjectMapper;
import com.example.studentsystem.service.NewsletterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("newsletterServiceImpl")
public class NewsletterServiceImpl implements NewsletterService {
    @Resource
    private NewsLetterMapper newsLetterMapper;

    @Resource
    private SubscribedNewsletterMapper subscribedNewsletterMapper;

    @Resource
    private SubscribedSubjectMapper subscribedSubjectMapper;

    @Resource
    private NewsSubjectMapper newsSubjectMapper;

    @Override
    public List<NewsLetter> findAllNewsletter() {

        NewsLetterExample newsLetterExample = new NewsLetterExample();
        NewsLetterExample.Criteria criteria = newsLetterExample.createCriteria();
        criteria.andNewsidIsNotNull();

        return newsLetterMapper.selectByExample(newsLetterExample);
    }

    @Override
    public List<NewsSubject> findAllSubject() {
        NewsSubjectExample newsSubjectExample = new NewsSubjectExample();
        NewsSubjectExample.Criteria criteria = newsSubjectExample.createCriteria();
        criteria.andSubjectIsNotNull();
        criteria.andSubjectNotEqualTo("fee");

        return newsSubjectMapper.selectByExample(newsSubjectExample);
    }

    @Override
    public List<NewsLetter> findAllNewsLetterByStudentid(Integer studentid) {

        SubscribedNewsletterExample subscribedNewsletterExample = new SubscribedNewsletterExample();
        SubscribedNewsletterExample.Criteria criteria1 = subscribedNewsletterExample.createCriteria();
        criteria1.andStudentidEqualTo(studentid);

        List<SubscribedNewsletterKey> allSubscribed = subscribedNewsletterMapper.selectByExample(subscribedNewsletterExample);
        List<Integer> forCriteria2 = new ArrayList<Integer>();
        for (SubscribedNewsletterKey subscribed : allSubscribed) {
            forCriteria2.add(subscribed.getNewsid());
        }

        NewsLetterExample newsLetterExample = new NewsLetterExample();
        NewsLetterExample.Criteria criteria2 = newsLetterExample.createCriteria();
        criteria2.andNewsidIn(forCriteria2);
        return newsLetterMapper.selectByExample(newsLetterExample);

    }

    @Override
    public List<NewsSubject> findAllSubjectByStudentid(Integer studentid) {
        SubscribedSubjectExample subscribedSubjectExample = new SubscribedSubjectExample();
        SubscribedSubjectExample.Criteria criteria1 = subscribedSubjectExample.createCriteria();
        criteria1.andStudentidEqualTo(studentid);

        List<SubscribedSubject> allSubscribed = subscribedSubjectMapper.selectByExample(subscribedSubjectExample);
        List<String> forCriteria2 = new ArrayList<String>();
        for (SubscribedSubject subscribed : allSubscribed) {
            forCriteria2.add(subscribed.getSubject());
        }

        NewsSubjectExample newsSubjectExample = new NewsSubjectExample();
        NewsSubjectExample.Criteria criteria2 = newsSubjectExample.createCriteria();
        criteria2.andSubjectIn(forCriteria2);

        return newsSubjectMapper.selectByExample(newsSubjectExample);

    }

    @Override
    public Integer deleteSubscribedNewsLetter(Integer studentid, Integer newsid) {
        SubscribedNewsletterExample subscribedNewsletterExample = new SubscribedNewsletterExample();
        SubscribedNewsletterExample.Criteria criteria = subscribedNewsletterExample.createCriteria();
        criteria.andNewsidEqualTo(newsid);
        criteria.andStudentidEqualTo(studentid);

        return subscribedNewsletterMapper.deleteByExample(subscribedNewsletterExample);
    }

    @Override
    public Integer deleteSubscribedSubject(Integer studentid, String subject) {

        SubscribedSubjectExample subscribedSubjectExample = new SubscribedSubjectExample();
        SubscribedSubjectExample.Criteria criteria = subscribedSubjectExample.createCriteria();
        criteria.andSubjectEqualTo(subject);
        criteria.andStudentidEqualTo(studentid);

        return subscribedSubjectMapper.deleteByExample(subscribedSubjectExample);

    }
    @Override
    public Integer deleteAnewsLetter(Integer newsid) {
        NewsLetterExample newsLetterExample=new NewsLetterExample();
        SubscribedNewsletterExample subscribedNewsletterExample = new SubscribedNewsletterExample();
        NewsLetterExample.Criteria criteria = newsLetterExample.createCriteria();
        criteria.andNewsidEqualTo(newsid);

        return subscribedNewsletterMapper.deleteByExample(subscribedNewsletterExample);
    }
    @Override
    public Integer SubscribeNewsLetterSubject(Integer studentid, String subject) {
        SubscribedSubject subscribedSubject = new SubscribedSubject();
        subscribedSubject.setStudentid(studentid);
        subscribedSubject.setSubject(subject);

        return subscribedSubjectMapper.insert(subscribedSubject);
    }

    @Override
    public Integer AddNewsletter(Integer newsid, String newsname, String publisher, String subject,
                                 String newsmsg, Date publishtime, Integer newstype) {
        NewsLetter newsletterObj = new NewsLetter();
        newsletterObj.setNewsid(newsid);
        newsletterObj.setNewsname(newsname);
        newsletterObj.setNewstype(newstype);
        newsletterObj.setNewsmessage(newsmsg);
        newsletterObj.setPublisher(publisher);
        newsletterObj.setPublishtime(publishtime);
        newsletterObj.setSubject(subject);

        return newsLetterMapper.insert(newsletterObj);
    }

    @Override
    public Integer AddNewsletterKey(Integer newsid, Integer studentid) {
        SubscribedNewsletterKey subscribedNewsletterKey = new SubscribedNewsletterKey();
        subscribedNewsletterKey.setNewsid(newsid);
        subscribedNewsletterKey.setStudentid(studentid);

        return subscribedNewsletterMapper.insert(subscribedNewsletterKey);
    }

    @Override
    public List<Integer> findAllStudentidBySubject(String subject) {
        SubscribedSubjectExample subscribedSubjectExample = new SubscribedSubjectExample();
        SubscribedSubjectExample.Criteria criteria1 = subscribedSubjectExample.createCriteria();
        criteria1.andSubjectEqualTo(subject);

        List<SubscribedSubject> allSubscribed = subscribedSubjectMapper.selectByExample(subscribedSubjectExample);
        List<Integer> forCriteria2 = new ArrayList<Integer>();
        for (SubscribedSubject subscribed : allSubscribed) {
            forCriteria2.add(subscribed.getStudentid());
        }
        return forCriteria2;

    }
}

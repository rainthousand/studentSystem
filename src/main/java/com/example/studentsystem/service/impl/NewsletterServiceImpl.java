package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.mapper.NewsLetterMapper;
import com.example.studentsystem.mapper.SelectedCourseMapper;
import com.example.studentsystem.mapper.SubscribeNewsMapper;
import com.example.studentsystem.pattern.observer.Newsletter;
import com.example.studentsystem.service.NewsletterService;
import org.hibernate.annotations.Source;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("newsletterServiceImpl")
public class NewsletterServiceImpl implements NewsletterService {
    @Resource
    private NewsLetterMapper newsLetterMapper;

    @Resource
    private SubscribeNewsMapper subscribeNewsMapper;

    @Override
    public List<NewsLetter> findAllNewsletter() {
        return null;
    }

    @Override
    public List<NewsLetter> findAllNewsLetterByStudentid(Integer studentid) {
        return null;
    }

    @Override
    public Integer deleteSubscribedNewsLetter(Integer studentid, Integer newsid) {
        return null;
    }

    @Override
    public Integer SubscribeNewsLetter(Integer studentid, Integer newsid) {
        return null;
    }
}

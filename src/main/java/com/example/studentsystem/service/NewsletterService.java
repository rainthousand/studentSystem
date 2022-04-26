package com.example.studentsystem.service;

import com.example.studentsystem.entity.NewsLetter;

import java.util.List;

public interface NewsletterService {
    List<NewsLetter> findAllNewsletter();

    List<NewsLetter> findAllNewsLetterByStudentid(Integer studentid);

    Integer deleteSubscribedNewsLetter(Integer studentid, Integer newsid);

    Integer SubscribeNewsLetter(Integer studentid, Integer newsid);
}

package com.example.studentsystem.service;

import com.example.studentsystem.entity.NewsLetter;
import com.example.studentsystem.entity.NewsSubject;
import com.example.studentsystem.entity.Student;

import java.util.Date;
import java.util.List;

public interface NewsletterService {
    List<NewsLetter> findAllNewsletter();

    List<NewsSubject> findAllSubject();

    List<NewsLetter> findAllNewsLetterByStudentid(Integer studentid);

    List<NewsSubject> findAllSubjectByStudentid(Integer studentid);

    Integer deleteSubscribedNewsLetter(Integer studentid, Integer newsid);

    Integer deleteSubscribedSubject(Integer studentid, String subject);

    Integer SubscribeNewsLetterSubject(Integer studentid, String subject);

    Integer AddNewsletter(Integer newsid, String newsname, String publisher, String subject, String newsmsg,
                          Date publishtime, Integer newstype);

    Integer AddNewsletterKey(Integer newsid, Integer studentid);

    List<Integer> findAllStudentidBySubject(String subject);

}

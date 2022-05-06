package com.example.studentsystem.pattern.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student implements Observer {
    private Integer studentid;
    private String realname;
    private String sex;
    private Date birthyear;
    private Date grade;
    private Integer collegeid;
    private Integer majorid;

    public Student(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(Date birthyear) {
        this.birthyear = birthyear;
    }

    public Date getGrade() {
        return grade;
    }

    public void setGrade(Date grade) {
        this.grade = grade;
    }

    public Integer getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    @Override
    public List<Integer> update(Integer newsid) {
        List<Integer> idKey=new ArrayList<>();
        idKey.add(newsid);
        idKey.add(studentid);
        return idKey;
    }

}
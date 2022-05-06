package com.example.studentsystem.pattern.decorator;

import com.example.studentsystem.entity.Course;

import java.util.Date;

public class MathCourse extends decorator{
    private Integer courseid;
    private String coursename;
    private Integer teacherid;
    private String coursetime;
    private String classroom;
    private Integer courseweek;
    private String coursetype;
    private Integer majorid;
    private Integer credit;
    private Date coursestart;
    private Date courseend;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Integer getCourseweek() {
        return courseweek;
    }

    public void setCourseweek(Integer courseweek) {
        this.courseweek = courseweek;
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype;
    }

    public Integer getMajorid() {
        return majorid;
    }

    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Date getCoursestart() {
        return coursestart;
    }

    public void setCoursestart(Date coursestart) {
        this.coursestart = coursestart;
    }

    public Date getCourseend() {
        return courseend;
    }

    public void setCourseend(Date courseend) {
        this.courseend = courseend;
    }

    public MathCourse(CourseInterface courseInterface) {
        super(courseInterface);
    }

    public Course courseMajor(Course course) {

        course.setCourseid(this.getCourseid());
        course.setCoursename(this.getCoursename());
        course.setTeacherid(this.getTeacherid());
        course.setCoursetime(this.getCoursetime());
        course.setClassroom(this.getClassroom());
        course.setCourseweek(this.getCourseweek());
        course.setCoursetype(this.getCoursetype());
        course.setMajorid(this.getMajorid());
        course.setCredit(this.getCredit());
        course.setCoursestart(this.getCoursestart());
        course.setCourseend(this.getCourseend());

        return course;
    }
}

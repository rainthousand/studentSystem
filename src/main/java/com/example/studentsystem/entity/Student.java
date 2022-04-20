package com.example.studentsystem.entity;

import java.util.Date;

public class Student {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.studentID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer studentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.realName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String realname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sex
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.birthYear
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Date birthyear;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.grade
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Date grade;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.collegeID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer collegeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.majorID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer majorid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.studentID
     *
     * @return the value of student.studentID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.studentID
     *
     * @param studentid the value for student.studentID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.realName
     *
     * @return the value of student.realName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.realName
     *
     * @param realname the value for student.realName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sex
     *
     * @return the value of student.sex
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sex
     *
     * @param sex the value for student.sex
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.birthYear
     *
     * @return the value of student.birthYear
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Date getBirthyear() {
        return birthyear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.birthYear
     *
     * @param birthyear the value for student.birthYear
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setBirthyear(Date birthyear) {
        this.birthyear = birthyear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.grade
     *
     * @return the value of student.grade
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Date getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.grade
     *
     * @param grade the value for student.grade
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setGrade(Date grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.collegeID
     *
     * @return the value of student.collegeID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.collegeID
     *
     * @param collegeid the value for student.collegeID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.majorID
     *
     * @return the value of student.majorID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getMajorid() {
        return majorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.majorID
     *
     * @param majorid the value for student.majorID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }
}
package com.example.studentsystem.entity;

public class SubscribedSubjectKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribednewsletter.newsID
     *
     * @mbggenerated Thu Apr 28 23:11:09 BST 2022
     */
    private Integer newsid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribednewsletter.studentID
     *
     * @mbggenerated Thu Apr 28 23:11:09 BST 2022
     */
    private Integer studentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribednewsletter.newsID
     *
     * @return the value of subscribednewsletter.newsID
     * @mbggenerated Thu Apr 28 23:11:09 BST 2022
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribednewsletter.newsID
     *
     * @param newsid the value for subscribednewsletter.newsID
     * @mbggenerated Thu Apr 28 23:11:09 BST 2022
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribednewsletter.studentID
     *
     * @return the value of subscribednewsletter.studentID
     * @mbggenerated Thu Apr 28 23:11:09 BST 2022
     */
    public Integer getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribednewsletter.studentID
     *
     * @param studentid the value for subscribednewsletter.studentID
     * @mbggenerated Thu Apr 28 23:11:09 BST 2022
     */
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }
}
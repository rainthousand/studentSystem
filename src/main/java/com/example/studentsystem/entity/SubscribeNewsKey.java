package com.example.studentsystem.entity;

public class SubscribeNewsKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribenews.newsletterID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer newsletterid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subscribenews.studentID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer studentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribenews.newsletterID
     *
     * @return the value of subscribenews.newsletterID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getNewsletterid() {
        return newsletterid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribenews.newsletterID
     *
     * @param newsletterid the value for subscribenews.newsletterID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setNewsletterid(Integer newsletterid) {
        this.newsletterid = newsletterid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subscribenews.studentID
     *
     * @return the value of subscribenews.studentID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getStudentid() {
        return studentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subscribenews.studentID
     *
     * @param studentid the value for subscribenews.studentID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }
}
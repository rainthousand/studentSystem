package com.example.studentsystem.entity;

public class Major {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.majorID
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    private Integer majorid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.majorName
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    private String majorname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column major.collegeID
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    private Integer collegeid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.majorID
     *
     * @return the value of major.majorID
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    public Integer getMajorid() {
        return majorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.majorID
     *
     * @param majorid the value for major.majorID
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.majorName
     *
     * @return the value of major.majorName
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    public String getMajorname() {
        return majorname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.majorName
     *
     * @param majorname the value for major.majorName
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column major.collegeID
     *
     * @return the value of major.collegeID
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    public Integer getCollegeid() {
        return collegeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column major.collegeID
     *
     * @param collegeid the value for major.collegeID
     *
     * @mbggenerated Thu Apr 21 22:05:52 BST 2022
     */
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }
}
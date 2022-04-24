package com.example.studentsystem.entity;

public class Feeforshow {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fee.feeID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer feeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fee.feeAmount
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer feeamount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fee.feePayerUserName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String feepayerusername;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fee.feeStatus
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String feestatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fee.feeOnlineOrOffline
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String feeonlineoroffline;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fee.feePaymentMethod
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String feepaymentmethod;


    public Feeforshow(Integer feeid, Integer feeamount, String feepayerusername, String feestatus, String feeonlineoroffline, String feepaymentmethod){
        this.feeamount = feeamount;
        this.feeid = feeid;
        this.feeonlineoroffline = feeonlineoroffline;
        this.feepayerusername = feepayerusername;
        this.feepaymentmethod = feepaymentmethod;
        this.feestatus = feestatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fee.feeID
     *
     * @return the value of fee.feeID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getFeeid() {
        return feeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fee.feeID
     *
     * @param feeid the value for fee.feeID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setFeeid(Integer feeid) {
        this.feeid = feeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fee.feeAmount
     *
     * @return the value of fee.feeAmount
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getFeeamount() {
        return feeamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fee.feeAmount
     *
     * @param feeamount the value for fee.feeAmount
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setFeeamount(Integer feeamount) {
        this.feeamount = feeamount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fee.feePayerUserName
     *
     * @return the value of fee.feePayerUserName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getFeepayerusername() {
        return feepayerusername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fee.feePayerUserName
     *
     * @param feepayerusername the value for fee.feePayerUserName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setFeepayerusername(String feepayerusername) {
        this.feepayerusername = feepayerusername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fee.feeStatus
     *
     * @return the value of fee.feeStatus
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getFeestatus() {
        return feestatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fee.feeStatus
     *
     * @param feestatus the value for fee.feeStatus
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setFeestatus(String feestatus) {
        this.feestatus = feestatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fee.feeOnlineOrOffline
     *
     * @return the value of fee.feeOnlineOrOffline
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getFeeonlineoroffline() {
        return feeonlineoroffline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fee.feeOnlineOrOffline
     *
     * @param feeonlineoroffline the value for fee.feeOnlineOrOffline
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setFeeonlineoroffline(String feeonlineoroffline) {
        this.feeonlineoroffline = feeonlineoroffline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fee.feePaymentMethod
     *
     * @return the value of fee.feePaymentMethod
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getFeepaymentmethod() {
        return feepaymentmethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fee.feePaymentMethod
     *
     * @param feepaymentmethod the value for fee.feePaymentMethod
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setFeepaymentmethod(String feepaymentmethod) {
        this.feepaymentmethod = feepaymentmethod;
    }

}

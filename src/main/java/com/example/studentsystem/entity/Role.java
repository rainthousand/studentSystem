package com.example.studentsystem.entity;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.roleID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private Integer roleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.roleName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.permissions
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    private String permissions;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.roleID
     *
     * @return the value of role.roleID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.roleID
     *
     * @param roleid the value for role.roleID
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.roleName
     *
     * @return the value of role.roleName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.roleName
     *
     * @param rolename the value for role.roleName
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.permissions
     *
     * @return the value of role.permissions
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.permissions
     *
     * @param permissions the value for role.permissions
     *
     * @mbggenerated Wed Apr 20 11:34:33 BST 2022
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
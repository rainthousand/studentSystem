package com.example.studentsystem.entity;

public class UserSessionInfo {
    private String Username;
    private String Password;
    private Integer RegisterStatus;

    public UserSessionInfo(String username, String password, Integer registerStatus) {
        Username = username;
        Password = password;
        RegisterStatus = registerStatus;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getRegisterStatus() {
        return RegisterStatus;
    }

    public void setRegisterStatus(Integer registerStatus) {
        RegisterStatus = registerStatus;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}

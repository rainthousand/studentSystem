package com.example.studentsystem.service;


import com.example.studentsystem.entity.UserLogin;

import java.util.List;

/**
 * Login Service Interface
 *
 */
public interface UserLoginService {

    // find user by username
    UserLogin findByUserName(String name) throws Exception;

    //save the user login info
    void save(UserLogin userlogin) throws Exception;

    //remove by userame
    void removeByUserName(String name) throws Exception;

    //update by username
    void updateByUserName(String name, UserLogin userlogin);

    //find all users
    List<UserLogin> findAll() throws Exception;
}

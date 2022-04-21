package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.UserLogin;
import com.example.studentsystem.entity.UserLoginExample;
import com.example.studentsystem.mapper.UserLoginMapper;
import com.example.studentsystem.service.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userloginServiceImpl")
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private UserLoginMapper userloginMapper;

    @Override
    public UserLogin findByUserName(String name) throws Exception {
        UserLoginExample userloginExample = new UserLoginExample();

        UserLoginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        List<UserLogin> list = userloginMapper.selectByExample(userloginExample);

        return list.get(0);
    }

    @Override
    public void save(UserLogin userlogin) throws Exception {
        userloginMapper.insert(userlogin);
    }

    @Override
    public void removeByUserName(String name) throws Exception {
        UserLoginExample userloginExample = new UserLoginExample();

        UserLoginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.deleteByExample(userloginExample);
    }

    @Override
    public void updateByUserName(String name, UserLogin userlogin) {
        UserLoginExample userloginExample = new UserLoginExample();

        UserLoginExample.Criteria criteria = userloginExample.createCriteria();
        criteria.andUsernameEqualTo(name);

        userloginMapper.updateByExample(userlogin, userloginExample);
    }

    @Override
    public List<UserLogin> findAll() throws Exception {
        UserLoginExample example = new UserLoginExample();
        return userloginMapper.selectByExample(example);
    }
}

package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Role;
import com.example.studentsystem.mapper.RoleMapper;
import com.example.studentsystem.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role findByid(Integer id) throws Exception {
        return roleMapper.selectByPrimaryKey(id);
    }
}
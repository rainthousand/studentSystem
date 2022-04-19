package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.TestTable;
import com.example.studentsystem.entity.TestTableExample;
import com.example.studentsystem.mapper.TestTableMapper;
import com.example.studentsystem.service.testfileservice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class testserviceimpl implements testfileservice {

    @Resource
    private TestTableMapper testTableMapper;

    @Override
    public List<TestTable> finAll() throws Exception {
        TestTableExample testTableExample = new TestTableExample();
        TestTableExample.Criteria criteria = testTableExample.createCriteria();

        criteria.andTestidIsNotNull();

        return testTableMapper.selectByExample(testTableExample);
    }
}

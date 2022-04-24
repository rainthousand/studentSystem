package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.FeeExample;
import com.example.studentsystem.mapper.FeeMapper;
import com.example.studentsystem.service.FeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("feeServiceImpl")
public class FeeServiceImpl implements FeeService {
    @Resource
    private FeeMapper feeMapper;

    @Override
    public Fee findFeeByUserName(Integer name) throws Exception {
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeepayerusernameEqualTo(name);

        return feeMapper.selectByExample(feeExample).get(0);
    }

    @Override
    public List<Fee> findAllFee() {
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeeidIsNotNull();

        return feeMapper.selectByExample(feeExample);
    }

    public Fee findFeeById(Integer id) throws Exception{
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeeidEqualTo(id);

        return feeMapper.selectByExample(feeExample).get(0);
    }
}

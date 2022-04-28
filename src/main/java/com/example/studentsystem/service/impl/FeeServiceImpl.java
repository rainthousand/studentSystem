package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.FeeExample;
import com.example.studentsystem.mapper.FeeMapper;
import com.example.studentsystem.pattern.state.Context;
import com.example.studentsystem.pattern.state.NotRegistered;
import com.example.studentsystem.pattern.state.Pending;
import com.example.studentsystem.service.FeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
//    @Override
//    public int UpdateByStatus(HttpSession session,Integer name, Integer feeStatus){
//        Fee fee = new Fee();
//
//    }

    @Override
    public int UpdateByUserName(HttpSession session,Integer name, Integer feeAmount, String feePaymentMethod, String feeOnlineOrOffline) throws Exception {
        Fee fee = new Fee();
//        fee.setFeepayerusername(name);
//        Integer oldamount=fee.getFeeamount();
//        TODO:如果有此处的amount为0，则需要更改注册状态
        fee.setFeeamount(feeAmount);
        fee.setFeepaymentmethod(feePaymentMethod);
        if(feeOnlineOrOffline=="Online"){
            fee.setFeeonlineoroffline(1);
        }else if (feeOnlineOrOffline=="Offline"){
            fee.setFeeonlineoroffline(2);
        }
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeepayerusernameEqualTo(name);
        if(feeAmount==0){
            Context context = new Context();
            context.shiftPending();
            fee.setFeestatus(2);
        }

        return feeMapper.updateByExampleSelective(fee,feeExample);
    }

    public Fee findFeeById(Integer id) throws Exception{
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeeidEqualTo(id);

        return feeMapper.selectByExample(feeExample).get(0);
    }

}

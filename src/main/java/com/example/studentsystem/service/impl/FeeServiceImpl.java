package com.example.studentsystem.service.impl;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.FeeExample;
import com.example.studentsystem.entity.SubscribedNewsletterKey;
import com.example.studentsystem.entity.SubscribedNewsletterExample;
import com.example.studentsystem.mapper.FeeMapper;
import com.example.studentsystem.pattern.state_reg.Context;
import com.example.studentsystem.service.FeeService;
import org.springframework.stereotype.Service;
import com.example.studentsystem.mapper.SubscribedNewsletterMapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Service("feeServiceImpl")
public class FeeServiceImpl implements FeeService {
    @Resource
    private FeeMapper feeMapper;
    @Resource
    private SubscribedNewsletterMapper subscribeNewsMapper;


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

    @Override
    public int UpdateByUserName(HttpSession session,Integer name, Integer feeAmount, String feePaymentMethod, Integer feeOnlineOrOffline) throws Exception {
        Fee fee = new Fee();
//        TODO:如果有此处的amount为0，则需要更改注册状态
        fee.setFeeamount(feeAmount);
        if(feePaymentMethod=="Visa card") fee.setFeepaymentmethod(1);
        else if(feePaymentMethod=="Master card") fee.setFeepaymentmethod(2);
        else if(feePaymentMethod=="Alipay") fee.setFeepaymentmethod(3);
        else fee.setFeepaymentmethod(4);
        fee.setFeeonlineoroffline(feeOnlineOrOffline);
//        if(feeOnlineOrOffline=="Online"){
//            fee.setFeeonlineoroffline(1);
//        }else if (feeOnlineOrOffline=="Offline"){
//            fee.setFeeonlineoroffline(2);
//        }
        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeepayerusernameEqualTo(name);
        if(feeAmount==0){
            Context context = new Context();
            context.shiftPending();
            fee.setFeestatus(2);
            //TODO subscribe newsletter部分的更新与删除
            updateSubNews(name);
        }

        return feeMapper.updateByExampleSelective(fee,feeExample);
    }
    @Override
    public Integer confirmPending(Integer feeid, Integer feepayerusername, Integer feeamount, String feestatus, String feeonlineorline, String feepaymentmethod){
        Fee fee = new Fee();
        fee.setFeeid(feeid);
        fee.setFeepayerusername(feepayerusername);
        fee.setFeestatus(1);
        deleteSubNews(feepayerusername);
        fee.setFeeamount(feeamount);
        if(Objects.equals(feeonlineorline, "Online")){
            fee.setFeeonlineoroffline(1);
        }
        else{
            fee.setFeeonlineoroffline(2);
        }
        if(feepaymentmethod=="Visa card") fee.setFeepaymentmethod(1);
        else if(feepaymentmethod=="Master card") fee.setFeepaymentmethod(2);
        else if(feepaymentmethod=="Alipay") fee.setFeepaymentmethod(3);
        else fee.setFeepaymentmethod(4);

        FeeExample feeExample = new FeeExample();
        FeeExample.Criteria criteria = feeExample.createCriteria();
        criteria.andFeeidEqualTo(feeid);
        return feeMapper.updateByExampleSelective(fee,feeExample);
    }

    @Override
    public int updateSubNews(Integer studentId) {
        SubscribedNewsletterKey subscribeNewsKey=new SubscribedNewsletterKey();
        subscribeNewsKey.setNewsid(1001);
        SubscribedNewsletterExample subscribedNewsletterExample = new SubscribedNewsletterExample();
        SubscribedNewsletterExample.Criteria criteria = subscribedNewsletterExample.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        criteria.andNewsidEqualTo(1000);
        return 1;
//        return subscribeNewsMapper.updateByExampleSelective(subscribeNewsKey,subscribedNewsletterExample);
    }

    @Override
    public int deleteSubNews(Integer studentId) {
        SubscribedNewsletterExample subscribedNewsletterExample = new SubscribedNewsletterExample();
        SubscribedNewsletterExample.Criteria criteria = subscribedNewsletterExample.createCriteria();
        criteria.andStudentidEqualTo(studentId);
        return subscribeNewsMapper.deleteByExample(subscribedNewsletterExample);
    }

}

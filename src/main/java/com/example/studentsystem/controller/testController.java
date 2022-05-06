package com.example.studentsystem.controller;


import com.example.studentsystem.entity.TestTable;
import com.example.studentsystem.service.testfileservice;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/hello")
public class testController {

    @Resource(name = "testserviceimpl")
    private testfileservice testService;

    @RequestMapping(value = "/test")
    public String test(Model model) throws Exception {
//        TestTable person = new TestTable();
//        person.setTestid(1);
//        person.setTestname("张三");
//        person.setTestdesc("zhangsan");
//        test person = new test();
//        person.setName("张三");
//        person.setAge(22);

        List<TestTable> list = testService.finAll();
        TestTable person = list.get(0);
//        test p1 = new test();
//        p1.setName("李四");
//        p1.setAge(23);
//        TestTable p1 = new TestTable();
//        p1.setTestid(2);
//        p1.setTestname("李四");
//        p1.setTestdesc("lisi");
//        list.add(p1);

//        test p2 = new test();
//        p2.setName("王五");
//        p2.setAge(24);
//        TestTable p2 = new TestTable();
//        p2.setTestid(3);
//        p2.setTestname("王五");
//        p2.setTestdesc("wangwu");
//        list.add(p2);

//        test p3 = new test();
//        p3.setName("赵六");
//        p3.setAge(25);
//        TestTable p3 = new TestTable();
//        p3.setTestid(3);
//        p3.setTestname("赵六");
//        p3.setTestdesc("zhaoliu");
//        list.add(p3);

        model.addAttribute("person", person);
        model.addAttribute("list", list);
        return "index2";
    }

    @RequestMapping(value = "/getJson")
    @ResponseBody
    public String getJson () throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("msg","成功");
        return jsonObject.toString();
    }
}
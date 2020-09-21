package com.ahead.blockchain.controller;

import com.ahead.blockchain.entity.Test;
import com.ahead.blockchain.servlet.TestServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    TestServlet testServlet;

    @GetMapping("/test")
    @ResponseBody
    public String save(){
        Test test = new Test();
        test.setId(1L);
        test.setName("abc");
        testServlet.save(test);
        return "success";
    }

    @GetMapping("/abc")
    public String test(){
        return "test";
    }

    @PostMapping("/saveTest")
    @ResponseBody
    public String saveTest(Test test){
        testServlet.save(test);
        return "成功";
    }
}

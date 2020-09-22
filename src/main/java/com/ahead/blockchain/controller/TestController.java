package com.ahead.blockchain.controller;

import com.ahead.blockchain.entity.Test;
import com.ahead.blockchain.servlet.TestServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public String test(Model model){
        List<Test> testList = testServlet.findAll();
        model.addAttribute("key",testList);
        return "test";
    }

    @PostMapping("/saveTest")
    public String saveTest(Test test){
        testServlet.save(test);
        //重定向
        return "redirect:/abc";
    }

//    @GetMapping("def")
//    public String def(Model model){
//        List<Test> testList = testServlet.findAll();
//        model.addAttribute("key",testList);
//        return "def";
//    }
}

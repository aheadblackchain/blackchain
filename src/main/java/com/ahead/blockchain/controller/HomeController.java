package com.ahead.blockchain.controller;

import com.ahead.blockchain.servlet.HomeServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @Autowired
    private HomeServlet homeServlet;

    @GetMapping("/home")
    public String hello(){
        System.out.println(homeServlet.findAll());
        return "/home.html";
    }
}

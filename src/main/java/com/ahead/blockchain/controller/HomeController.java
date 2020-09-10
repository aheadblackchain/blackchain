package com.ahead.blockchain.controller;

import com.ahead.blockchain.servlet.HomeServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private HomeServlet homeServlet;

    @GetMapping("/home")
    public String hello(Model model){
        model.addAttribute("homeList",homeServlet.findAll());
        return "website/index";
    }
}

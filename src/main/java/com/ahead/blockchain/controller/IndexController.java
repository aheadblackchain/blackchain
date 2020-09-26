package com.ahead.blockchain.controller;

import com.ahead.blockchain.servlet.DomainServlet;
import com.ahead.blockchain.servlet.HomeServlet;
import com.ahead.blockchain.servlet.NewsServlet;
import com.ahead.blockchain.servlet.SurroundingServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private HomeServlet homeServlet;
    private DomainServlet domainServlet;
    private NewsServlet newsServlet;
    private  final SurroundingServlet surroundingServlet;

    public IndexController(DomainServlet domainServlet, NewsServlet newsServlet, SurroundingServlet surroundingServlet) {
        this.domainServlet = domainServlet;
        this.newsServlet = newsServlet;
        this.surroundingServlet = surroundingServlet;
    }

    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("homeList",homeServlet.findAll());
        model.addAttribute("domainList",domainServlet.domainList());
        model.addAttribute("newsList",newsServlet.newsList());
        model.addAttribute("surroundingList",surroundingServlet.surroundingList());
        return "website/index";
    }
}

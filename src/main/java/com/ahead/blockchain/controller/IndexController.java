package com.ahead.blockchain.controller;
import com.ahead.blockchain.servlet.DomainServlet;
import com.ahead.blockchain.servlet.HomeServlet;
import com.ahead.blockchain.servlet.NewsServlet;
import com.ahead.blockchain.servlet.SurroundingServlet;
import com.ahead.blockchain.servlet.CurriculumServlet;
import com.ahead.blockchain.servlet.TalentsServlet;

import com.ahead.blockchain.servlet.*;

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
    private TalentsServlet talentsServlet;
    private CurriculumServlet curriculumServlet;
    private ProjectServlet projectServlet;

    public IndexController(DomainServlet domainServlet, NewsServlet newsServlet, SurroundingServlet surroundingServlet) {
        this.domainServlet = domainServlet;
        this.newsServlet = newsServlet;
        this.surroundingServlet = surroundingServlet;
    }

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("homeList", homeServlet.findAll());

        model.addAttribute("talentList", talentsServlet.findAll());
        model.addAttribute("curriculumList", curriculumServlet.findAll());
        model.addAttribute("projectList",projectServlet.findAll());
        return "website/index";
    }
}

package com.ahead.blockchain.controller;

import com.ahead.blockchain.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private HomeServlet homeServlet;
    @Autowired
    private DomainServlet domainServlet;
    @Autowired
    private NewsServlet newsServlet;
    @Autowired
    private SurroundingServlet surroundingServlet;
    @Autowired
    private TalentsServlet talentsServlet;
    @Autowired
    private CurriculumServlet curriculumServlet;
    @Autowired
    private ProjectServlet projectServlet;
    @Autowired
    private AnimationServlet animationServlet;

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("homeList", homeServlet.findAll());
        model.addAttribute("animationList", animationServlet.findAll());
        model.addAttribute("talentList", talentsServlet.findAll());
        model.addAttribute("curriculumList", curriculumServlet.findAll());
<<<<<<< Updated upstream
        model.addAttribute("projectList", projectServlet.findAll());
        model.addAttribute("domainList", domainServlet.domainList());
        model.addAttribute("newsList", newsServlet.newsList());
        model.addAttribute("surroundingList", surroundingServlet.surroundingList());
=======
        model.addAttribute("projectList",projectServlet.findAll());
        model.addAttribute("domainList1",domainServlet.domainList());
        model.addAttribute("newsList1",newsServlet.newsList());
        model.addAttribute("surroundingList1",surroundingServlet.surroundingList());
>>>>>>> Stashed changes
        return "website/index";
    }
}

package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Domain;
import com.ahead.blockchain.servlet.DomainServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private DomainServlet domainServlet;
    @GetMapping("/list")
    public String domainList(Model model){
        model.addAttribute("domainList", domainServlet.domainList());
        return "back/domainlist";
    }

    @PostMapping("/byId/{id}")
    @ResponseBody
    public Domain getDomainById(@PathVariable("id") Long id){
        return domainServlet.getDomainById(id);
    }

    @PostMapping("/save")
    public String saveDomain(Domain domain){
        domainServlet.insertOrUpdate(domain);
        return "redirect:/domain/list";
    }

    @GetMapping("/del/{id}")
    public String delDomain(@PathVariable("id") Long id){
        domainServlet.delById(id);
        return "redirect:/domain/list";
    }
}

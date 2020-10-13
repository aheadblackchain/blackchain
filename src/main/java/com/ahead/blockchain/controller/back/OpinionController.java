package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Opinion;
import com.ahead.blockchain.servlet.OpinionServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    @Autowired
    private OpinionServlet opinionServlet;

    @GetMapping("/save")
    public String save(Opinion opinion){
        opinionServlet.saveOpinion(opinion);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list", opinionServlet.findAllOrderById());
        return "/back/opinionlist";
    }

    @PostMapping("/byId/{id}")
    @ResponseBody
    public Opinion byId(@PathVariable("id") Long id){
        return opinionServlet.getOpinion(id);
    }
}

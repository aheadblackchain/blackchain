package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Talents;
import com.ahead.blockchain.servlet.TalentsServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author solfeng
 * @date 2020/9/23 20:26
 */
@Controller
@RequestMapping("/talent")
public class TalentsController {
    @Autowired
    private TalentsServlet talentsServlet;

    @GetMapping("/list")
    public String talentList(Model model) {
        model.addAttribute("talentsList", talentsServlet.talentsList());
        return "back/talentslist";
    }

    @PostMapping("/ById/{id}")
    @ResponseBody
    public Talents getTalentsById(@PathVariable("id") Long id) {
        return talentsServlet.getTalentsById(id);
    }

    @PostMapping("/save")
    public String saveTalents(Talents talents) {
        talentsServlet.inserOrUpdate(talents);
        return "redirect:/talent/list";
    }

    @GetMapping("del/{id}")
    public String delTalents(@PathVariable("id") Long id) {
        talentsServlet.delById(id);
        return "redirect:/talent/list";
    }


}

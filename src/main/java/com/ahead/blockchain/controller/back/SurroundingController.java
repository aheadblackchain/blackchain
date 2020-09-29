package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Surrounding;
import com.ahead.blockchain.servlet.SurroundingServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/surrounding")
public class SurroundingController {

    @Autowired
    private SurroundingServlet surroundingServlet;

    @GetMapping("/info")
    public String blackChainRecommendimg(Model model) {
        model.addAttribute("surroundingList", surroundingServlet.surroundingList());
        return "website/surroundingimg";
    }

    @GetMapping("/list")
    public String surroundingList(Model model) {
        model.addAttribute("surroundingList", surroundingServlet.surroundingList());
        return "back/surroundinglist";
    }

    @PostMapping("/byId/{id}")
    @ResponseBody
    public Surrounding getSurroundingById(@PathVariable("id") Long id) {
        return surroundingServlet.getSurroundingById(id);
    }

    @PostMapping("/save")
    public String saveSurrounding(Surrounding surrounding) {
        surroundingServlet.insertOrUpdate(surrounding);
        return "redirect:/surrounding/list";
    }

    @GetMapping("/del/{id}")
    public String delSurrounding(@PathVariable("id") Long id) {
        surroundingServlet.delById(id);
        return "redirect:/surrounding/list";
    }
}

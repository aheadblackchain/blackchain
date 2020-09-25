package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Animation;
import com.ahead.blockchain.servlet.AnimationServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animation")
public class AnimationController {

    @Autowired
    private AnimationServlet animationServlet;
    @GetMapping("/list")
    public String animationList(Model model){
        model.addAttribute("animationList", animationServlet.animationList());
        return "back/animationlist";
    }

    @PostMapping("/byId/{id}")
    @ResponseBody
    public Animation getAnimationById(@PathVariable("id") Long id){
        return animationServlet.getAnimationById(id);
    }

    @PostMapping("/save")
    public String saveAnimation(Animation animation){
        animationServlet.insertOrUpdate(animation);
        return "redirect:/animation/list";
    }

    @GetMapping("/del/{id}")
    public String delAnimation(@PathVariable("id") Long id){
        animationServlet.delById(id);
        return "redirect:/animation/list";
    }
}

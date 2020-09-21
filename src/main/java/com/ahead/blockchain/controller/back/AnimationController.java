package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.entity.Animation;
import com.ahead.blockchain.servlet.AnimationServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnimationController {

    @Autowired
    private AnimationServlet animationServlet;
    @GetMapping("/animationList")
    public String animationList(Model model){
        model.addAttribute("animationList", animationServlet.animationList());
        return "back/animationlist";
    }

    @PostMapping("/getAnimationById/{id}")
    @ResponseBody
    public Animation getAnimationById(@PathVariable("id") Long id){
        return animationServlet.getAnimationById(id);
    }

    @PostMapping("/saveAnimation")
    public String saveAnimation(Animation animation){
        animationServlet.insertOrUpdate(animation);
        return "redirect:/animationList";
    }

    @GetMapping("/delAnimation/{id}")
    public String delAnimation(@PathVariable("id") Long id){
        animationServlet.delById(id);
        return "redirect:/animationList";
    }
}

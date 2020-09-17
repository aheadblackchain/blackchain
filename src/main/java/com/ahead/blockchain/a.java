package com.ahead.blockchain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class a {

    @GetMapping("/a")
    public String a(Model model){
        model.addAttribute("key","value");
        return "a";
    }
}

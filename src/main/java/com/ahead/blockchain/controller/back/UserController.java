package com.ahead.blockchain.controller.back;

import com.ahead.blockchain.servlet.UserServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserServlet userServlet;

    @GetMapping("/userlist")
    public String userList(Model model){
        model.addAttribute("userList", userServlet.userList());
        return "back/userlist";
    }

    @GetMapping("/login")
    public String toLoginPage(){
        return "back/login";
    }
}

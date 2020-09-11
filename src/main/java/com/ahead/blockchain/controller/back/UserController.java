package com.ahead.blockchain.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/userlist")
    public String userList(){
        return "back/userlist";
    }

    @GetMapping("/login")
    public String toLoginPage(){
        return "back/login";
    }
}

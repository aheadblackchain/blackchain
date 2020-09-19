package com.ahead.blockchain.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
    @GetMapping("/left")
    public String left(){
        return "back/left";
    }
}

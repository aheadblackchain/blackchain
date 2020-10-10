package com.ahead.blockchain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexBaseController {

    @GetMapping("/top")
    public String top() {
        return "website/top";
    }

    @GetMapping("/footer")
    public String footer() {
        return "website/footer";
    }

    @GetMapping("/projectInfo")
    public String projectInfo() {
        return "website/projectinfo";
    }

    @GetMapping("/newInfo")
    public String newInfo() {
        return "website/newinfo";
    }


    @GetMapping("/blackChainRecommendVideo")
    public String blackChainRecommend() {
        return "website/blackchainrecommendvideo";
    }
}

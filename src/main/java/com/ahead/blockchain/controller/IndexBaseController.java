package com.ahead.blockchain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexBaseController {

    @GetMapping("/blackChainRecommendVideo")
    public String blackChainRecommend(){
        return "website/blackchainrecommendvideo";
    }
    @GetMapping("/blackChainRecommendImg")
    public String blackChainRecommendimg(){
        return "website/blackchainrecommendimg";
    }

    @GetMapping("/info")
    public String info(){
        return "website/blackchaininfo";
    }
}

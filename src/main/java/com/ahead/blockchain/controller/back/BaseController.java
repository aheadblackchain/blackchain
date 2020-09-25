package com.ahead.blockchain.controller.back;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@Controller
public class BaseController {

    @Value("${file.upload.url}")
    private String UPLOAD_FILE_PATH;

    @Value("${file.pathPatterns.url}")
    private String PATH_PATTERNS;

    @GetMapping("/left")
    public String left(){
        return "back/left";
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileUpload") MultipartFile fileUpload){
        if(fileUpload.isEmpty()){
            return null;
        }
        try {
            String fileName = (new Date()).getTime()+ "." + fileUpload.getOriginalFilename().split("\\.")[1];
            String filePath = UPLOAD_FILE_PATH+fileName;
            File desc = new File(filePath);
            fileUpload.transferTo(desc);
            return PATH_PATTERNS+fileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @GetMapping("/login")
    public String toLoginPage(){
        return "back/login";
    }
}

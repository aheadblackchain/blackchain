package com.ahead.blockchain.controller.back;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class BaseController {
    @GetMapping("/left")
    public String left(){
        return "back/left";
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("fileUpload") MultipartFile fileUpload){
        if(fileUpload.isEmpty()){
            return "上传失败，没有读取到文件";
        }
        try {
            String fileName = fileUpload.getOriginalFilename();
//            File desc = new File("../../../../"+ResourceUtils.getURL("classpath:").getPath());
//            File desc = new File("D:\\ahead\\blockchain_project\\idea");
//            if(!desc.exists()) {
//                desc = new File(desc.getAbsolutePath(),"static/upload/");
//            }
//            fileUpdate.transferTo(desc);
            try (InputStream inputStream = fileUpload.getInputStream(); OutputStream out = new FileOutputStream(new File("D:\\ahead\\blockchain_project\\idea\\"+fileUpload.getOriginalFilename()))) {
                // files.transferTo(new File("c:/12.jpg"));
                IOUtils.copy(inputStream, out);
            }
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

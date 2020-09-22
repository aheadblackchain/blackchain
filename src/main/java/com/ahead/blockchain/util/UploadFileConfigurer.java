package com.ahead.blockchain.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UploadFileConfigurer implements WebMvcConfigurer {

    @Value("${file.upload.url}")
    private String UPLOAD_FILE_PATH;

    @Value("${file.pathPatterns.url}")
    private String PATH_PATTERNS;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(PATH_PATTERNS + "**").addResourceLocations("file:/" + UPLOAD_FILE_PATH);
    }
}

package com.ahead.blockchain.intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercept())
                .addPathPatterns("/user/**","/animation/**","/news/**","/opinion/**","/domain/**","/talents/**","/surroundings/**")
                .excludePathPatterns("/user/login","/news/newInfo/**","/opinion/save");
//                .excludePathPatterns("/login","/","/back/**","/website/**");
    }
}

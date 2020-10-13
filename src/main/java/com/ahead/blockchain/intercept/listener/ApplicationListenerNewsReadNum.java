package com.ahead.blockchain.intercept.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;

@WebListener
public class ApplicationListenerNewsReadNum implements ServletContextListener {
    private static ApplicationContext applicationContext = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        sce.getServletContext().setAttribute("readNum", new HashSet());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        //获取业务层service Bean
//        CourseServiceImpl courserService = (CourseServiceImpl)webApplicationContext.getBean("CourseServiceImpl");
//        courserService.updateRateUtilization();//更新点击量
        sce.getServletContext().removeAttribute("readNum");//移除全局变量--点击量
    }
}

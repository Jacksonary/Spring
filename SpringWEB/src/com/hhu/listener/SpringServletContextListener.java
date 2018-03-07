package com.hhu.listener;

import com.hhu.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听WEB应用程序的生命周期
 * Created by WeiguoLiu on 2018/3/4.
 */
public class SpringServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("应用初始化");
        //1.获取Spring的配置文件名
        ServletContext servletContext = sce.getServletContext();
        String config = servletContext.getInitParameter("configLocation");

        //1.创建IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //2.把IOC容器放在ServletContext的一个属性中
        servletContext.setAttribute("ApplicationContext", ctx);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

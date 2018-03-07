package com.hhu.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WeiguoLiu on 2018/2/26.
 */
public class Main {
    public static void main(String[] args) {
        //创建IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-autowire.xml");
        //获取bean实例
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);

        Person person2 = (Person) ctx.getBean("person2");
        System.out.println(person2);
    }
}

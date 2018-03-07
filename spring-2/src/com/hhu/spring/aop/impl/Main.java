package com.hhu.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WeiguoLiu on 2018/2/28.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Counter counter = (Counter) ctx.getBean("counter");
        System.out.println(counter.add(3, 4));
        System.out.println(counter.dev(3, 4));
        System.out.println(counter.sub(3, 4));
        System.out.println(counter.mul(3, 4));

    }
}

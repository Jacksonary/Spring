package com.hhu.spring.scope;

import com.hhu.spring.autowire.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WeiguoLiu on 2018/2/26.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scope.xml");
        Address address = (Address) ctx.getBean("address");
        Address address2 = (Address) ctx.getBean("address");
        System.out.println("address.equals(address2):" + address.equals(address2));

    }
}

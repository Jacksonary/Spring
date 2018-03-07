package com.hhu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WeiguoLiu on 2018/2/25.
 */
public class Main {

    public static void main(String[] args) {
//        //创建对象和为属性赋值可以交给Spring完成
//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setFirstName("HHU");

        //1.创建Spring的IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //从容器中获取Bean实例，并且进行对应类型的强转
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");

        helloWorld.hello();

        System.out.println(helloWorld);

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        Car car2 = (Car) applicationContext.getBean("car2");
        System.out.println(car2);
    }

}
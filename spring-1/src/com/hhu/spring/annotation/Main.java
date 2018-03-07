package com.hhu.spring.annotation;

import com.hhu.spring.annotation.controller.UserController;
import com.hhu.spring.annotation.repository.UserRepository;
import com.hhu.spring.annotation.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//        TestObject testObject = (TestObject) ctx.getBean("testObject");
//        System.out.println(testObject);

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

//        UserRepository userRepository = (UserRepository) ctx.getBean("userRepository");
//        System.out.println(userRepository);
//
//        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println(userService);


    }
}

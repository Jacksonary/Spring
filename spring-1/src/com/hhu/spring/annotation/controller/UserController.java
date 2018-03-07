package com.hhu.spring.annotation.controller;

import com.hhu.spring.annotation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
@Controller
public class UserController {
    @Autowired(required = false)
    private UserService userService;
    public void execute() {
        System.out.println("UserController execute...");
        userService.add();
    }

}

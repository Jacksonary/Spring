package com.hhu.spring.annotation.services;

import com.hhu.spring.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add() {
        System.out.println("UserService add...");
        userRepository.save();
    }
}

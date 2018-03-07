package com.hhu.spring.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRepository Save...");
    }
}

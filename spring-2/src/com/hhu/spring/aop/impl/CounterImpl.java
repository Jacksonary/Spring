package com.hhu.spring.aop.impl;

import org.springframework.stereotype.Component;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
@Component("counter")
public class CounterImpl implements Counter {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        return result;
    }

    @Override
    public int dev(int i, int j) {
        int result = i / j;
        return result;
    }
}

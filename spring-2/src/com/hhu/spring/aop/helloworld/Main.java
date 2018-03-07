package com.hhu.spring.aop.helloworld;

import java.lang.reflect.Proxy;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
public class Main {
    public static void main(String[] args) {
//        Counter c = new CounterWithLogImpl();
//        c.add(9,3);
//        c.sub(9,3);
//        c.mul(9,3);
//        c.dev(9,3);

        /**
         * 主要理解三个参数的含义：
         *
         */
        Counter counter = (Counter) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{Counter.class}, new CounterProxy(new CounterImpl()));
        counter.add(9, 3);
        counter.sub(9, 3);
        counter.mul(9, 3);
        counter.dev(9, 3);
    }
}

package com.hhu.spring.aop.helloworld;

/**
 * Created by WeiguoLiu on 2018/2/27.
 */
public class CounterWithLogImpl implements Counter {
    @Override
    public int add(int i, int j) {
        System.out.println("The mothod add begin with [" + i + ", " + j + "]");
        int result = i + j;
        System.out.println("The method add end with " + result);
        System.out.println();
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("The mothod sub begin with [" + i + ", " + j + "]");
        int result = i - j;
        System.out.println("The method sub end with " + result);
        System.out.println();
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("The mothod mul begin with [" + i + ", " + j + "]");
        int result = i * j;
        System.out.println("The method mul end with " + result);
        System.out.println();
        return result;
    }

    @Override
    public int dev(int i, int j) {
        System.out.println("The method dev begin with [" + i + ", " + j + "]");
        int result = i / j;
        System.out.println("The method dev end with " + result);
        System.out.println();
        return result;
    }
}

package com.hhu.bean;

/**
 * Created by WeiguoLiu on 2018/3/4.
 */
public class Person {
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void hello () {
        System.out.println("hello, my name is " + userName);
    }
}

package com.hhu.beans;

/**
 * Created by WeiguoLiu on 2018/3/5.
 */
public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello: my name is " + name);
    }
}

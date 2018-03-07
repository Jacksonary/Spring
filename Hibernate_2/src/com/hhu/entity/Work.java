package com.hhu.entity;

/**
 * Created by WeiguoLiu on 2018/3/6.
 */
public class Work {
    private Integer id;
    private String name;
    private Pay pay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }
}

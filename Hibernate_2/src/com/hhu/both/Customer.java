package com.hhu.both;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by WeiguoLiu on 2018/3/6.
 */
public class Customer {
    private Integer CId;
    private String CName;
    //添加多端的集合
    private Set<Order> orders = new HashSet<>();

    public Integer getCId() {
        return CId;
    }

    public void setCId(Integer CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}

package com.hhu.both;

/**
 * Created by WeiguoLiu on 2018/3/6.
 */
public class Order {
    private Integer OId;
    private String OName;
    //添加一端的引用
    private Customer customer;

    public Integer getOId() {
        return OId;
    }

    public void setOId(Integer OId) {
        this.OId = OId;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

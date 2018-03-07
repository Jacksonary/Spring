package com.hhu.spring.spel;

/**
 * Created by WeiguoLiu on 2018/2/26.
 */
public class Person {
    private String name;
    private String city;
    private Car car;
    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", car=" + car +
                ", info='" + info + '\'' +
                '}';
    }
}

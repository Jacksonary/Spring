package com.hhu.spring.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by WeiguoLiu on 2018/2/25.
 */
public class HelloWorld {
    private String name;

    private Car car;

    private List<Car> cars;

    private Map<Integer,String> map;

    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    //这里面的形参必须和Spring中配置文件一致，这里如果改成name2，那么配置文件中也必须
    //为name2
    public void setFirstName(String name) {
        this.name = name;
        System.out.println("setName:" + name);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCars(List cars) {
        this.cars = cars;
    }

    public void hello() {
        System.out.println("hello:" + name);
    }

    public HelloWorld() {
        System.out.println("HelloWorld被创建了");
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", cars=" + cars +
                ", map=" + map +
                '}';
    }
}

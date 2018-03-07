package com.hhu.spring.spel;

/**
 * Created by WeiguoLiu on 2018/2/26.
 */
public class Car {
    private String brand;
    private String corp;
    private double price;
    private double tyrePerimeter;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setTyrePerimeter(double tyrePerimeter) {
        this.tyrePerimeter = tyrePerimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", tyrePerimeter=" + tyrePerimeter +
                '}';
    }
}

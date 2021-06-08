package com.learn.bean;

public class Car {

    private Integer id;
    private String brand;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Car() {
    }
}

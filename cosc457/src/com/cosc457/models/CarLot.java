package com.cosc457.models;

/**
 * Created by Taylor on 5/7/2017.
 */
public class CarLot {
    private String address;
    private String capacity;
    private String name;

    public CarLot(String address, String capacity, String name) {
        this.address = address;
        this.capacity = capacity;
        this.name = name;
    }

    public CarLot(String address) {
        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Address:" + address + '\'' +
                ", capacity='" + capacity + '\'' +
                ", name='" + name + '\'';
    }
}

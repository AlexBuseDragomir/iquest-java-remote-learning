package com.iquest.java.problem1.car;

public class Car {

    private String brand;
    private int price;

    public Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    private int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Car car = (Car) obj;

        if (this.hashCode() != car.hashCode()) {
            return false;
        } else {
            return this.price == car.getPrice() &&
                    this.brand.equals(car.brand);
        }
    }

    @Override
    public int hashCode() {
        return this.brand.hashCode() + this.price;
    }

    @Override
    public String toString() {
        return this.brand + " car that costs " + this.price + "$";
    }
}
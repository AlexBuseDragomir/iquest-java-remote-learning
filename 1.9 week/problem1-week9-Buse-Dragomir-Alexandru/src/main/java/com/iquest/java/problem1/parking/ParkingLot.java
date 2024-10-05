package com.iquest.java.problem1.parking;

import com.iquest.java.problem1.car.Car;
import com.iquest.java.problem1.collection.MyCollection;
import com.iquest.java.problem1.implementation.SimpleCollection;

import java.util.List;

public class ParkingLot {

    private MyCollection<Car> carsInParkingLot;

    public ParkingLot() {
        this.carsInParkingLot = new SimpleCollection<>(new Car[0]);
    }

    public boolean addCarsToParkingLot(List<Car> cars) {
        return carsInParkingLot.addAll(cars);
    }

    public boolean checkIfCarsAreAdded(List<Car> cars) {
        return carsInParkingLot.containsAll(cars);
    }

    public Car[] getAllCars() {
        return this.carsInParkingLot.getElements();
    }

    public void printCarsFromParkingLot() {
        Car[] cars = this.carsInParkingLot.getElements();
        for (Car car: cars) {
            System.out.println(car + " ");
        }
    }
}

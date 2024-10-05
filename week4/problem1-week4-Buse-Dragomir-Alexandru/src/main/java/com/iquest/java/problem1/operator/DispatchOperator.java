package com.iquest.java.problem1.operator;

import com.iquest.java.problem1.driver.Driver;
import com.iquest.java.problem1.person.Person;

import java.util.List;

public class DispatchOperator extends Person implements Operator {

    private String fullName;
    private List<Driver> drivers;

    public DispatchOperator(String name, List<Driver> drivers) {
        this.fullName = name;
        this.drivers = drivers;
    }

    @Override
    public void eat() {
        System.out.println("Operator " + fullName + " eats");
    }

    public Driver getBestAvailableTaxi(String location) {
        return drivers.get(0);
    }

    public void dispatch(String location) {
        Driver availableTaxiDriver = this.getBestAvailableTaxi(location);
        int arrivingTime = availableTaxiDriver.goToAddress(location);
        System.out.println("Taxi will arrive in " + arrivingTime + " minutes");
    }

    @Override
    public String toString() {
        return "Dispatch operator " + this.fullName + " is working";
    }
}

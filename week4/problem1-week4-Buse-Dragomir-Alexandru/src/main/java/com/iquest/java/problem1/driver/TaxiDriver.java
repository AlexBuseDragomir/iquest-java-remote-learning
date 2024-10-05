package com.iquest.java.problem1.driver;

import com.iquest.java.problem1.person.Person;

public class TaxiDriver extends Person implements Driver {

    private String fullName;

    public TaxiDriver(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void eat() {
        System.out.println("Driver " + this.fullName + " eats");
    }

    @Override
    public void sleep() {
        System.out.println("Driver " + this.fullName + " sleeps");
    }

    public String getCurrentLocation() {
        return "dummy location";
    }

    public int goToAddress(String address) {
        System.out.println("Driver " + this.fullName + " goes to " + address);
        // dummy value
        return 2;
    }

    @Override
    public String toString() {
        return "Taxi driver " + this.fullName + " is driving";
    }
}

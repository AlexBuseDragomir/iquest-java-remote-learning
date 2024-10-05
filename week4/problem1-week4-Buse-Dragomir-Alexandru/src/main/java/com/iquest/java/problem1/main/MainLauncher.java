package com.iquest.java.problem1.main;

import com.iquest.java.problem1.driver.Driver;
import com.iquest.java.problem1.driver.TaxiDriver;
import com.iquest.java.problem1.operator.DispatchOperator;
import com.iquest.java.problem1.operator.Operator;

import java.util.ArrayList;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        Driver taxiDriver = new TaxiDriver("Mike Harrison");
        System.out.println(taxiDriver);
        System.out.println("Taxi driver current location: " +
                taxiDriver.getCurrentLocation());
        drivers.add(taxiDriver);
        Operator operator = new DispatchOperator("Dan Brown", drivers);
        System.out.println(operator);
        operator.dispatch("Herald Square - New York Herald");
    }
}
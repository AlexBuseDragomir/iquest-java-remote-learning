package com.iquest.java.problem1.operator;

import com.iquest.java.problem1.driver.Driver;

public interface Operator {

    Driver getBestAvailableTaxi(String location);
    void dispatch(String location);
}

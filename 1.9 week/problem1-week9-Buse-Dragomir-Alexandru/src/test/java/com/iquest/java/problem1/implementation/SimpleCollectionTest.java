package com.iquest.java.problem1.implementation;

import com.iquest.java.problem1.car.Car;
import com.iquest.java.problem1.parking.ParkingLot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleCollectionTest {

    private ParkingLot parkingLot;
    private List<Car> cars;
    @Before
    public void setUp() {
        this.parkingLot = new ParkingLot();
        this.cars = new ArrayList<>();
        this.cars.add(new Car("Tesla", 43000));
        this.cars.add(new Car("Mazda", 27000));
        this.cars.add(new Car("Opel", 19500));
        this.cars.add(new Car("Subaru", 39000));
        this.cars.add(new Car("Mitsubishi", 31500));
    }

    @Test
    public void testSimpleCollectionAddAll() {
        boolean successFlag = this.parkingLot.addCarsToParkingLot(this.cars);
        assertThat(successFlag, is(true));
        assertThat(this.parkingLot.getAllCars().length, is(this.cars.size()));
    }

    @Test
    public void testSimpleCollectionAddAllZeroElements() {
        boolean successFlag = this.parkingLot.addCarsToParkingLot(new ArrayList<>());
        assertThat(successFlag, is(false));
        assertThat(this.parkingLot.getAllCars().length, is(0));
    }

    @Test
    public void testSimpleCollectionAddAllNull() {
        boolean successFlag = this.parkingLot.addCarsToParkingLot(null);
        assertThat(successFlag, is(false));
    }

    @Test
    public void testSimpleCollectionContainsAllTrue() {
        this.parkingLot.addCarsToParkingLot(this.cars);
        boolean successFlag = parkingLot.checkIfCarsAreAdded(this.cars);
        assertThat(successFlag, is(true));
    }

    @Test
    public void testSimpleCollectionContainsAllFalse() {
        this.parkingLot.addCarsToParkingLot(this.cars);
        this.cars.add(new Car("Dacia", 9500));
        boolean successFlag = parkingLot.checkIfCarsAreAdded(this.cars);
        assertThat(successFlag, is(false));
    }
}
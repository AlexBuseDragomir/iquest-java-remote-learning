package com.iquest.java.problem2.utility;

import com.iquest.java.problem2.car.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortingUtilityTest {

    private SortingUtility sortingUtility;
    private List<Car> carList;
    private List<Integer> numberList;
    private List<String> stringList;

    @Before
    public void setUp() {
        sortingUtility = new SortingUtility();
        carList = new ArrayList<>();
        numberList = new LinkedList<>();
        stringList = new LinkedList<>();

        this.carList.add(new Car("Tesla", 43000));
        this.carList.add(new Car("Mazda", 27000));
        this.carList.add(new Car("Opel", 19500));
        this.carList.add(new Car("Subaru", 39000));
        this.carList.add(new Car("Mitsubishi", 31500));

        this.numberList.add(12);
        this.numberList.add(92);
        this.numberList.add(4);
        this.numberList.add(19);
        this.numberList.add(9);
        this.numberList.add(22);
        this.numberList.add(31);
        this.numberList.add(27);

        this.stringList.add("Maria");
        this.stringList.add("Joanna");
        this.stringList.add("Xenia");
        this.stringList.add("Anna");
        this.stringList.add("Haley");
        this.stringList.add("Diana");
        this.stringList.add("Amber");
        this.stringList.add("Layla");
    }

    @Test
    public void testCarSort() {
        List<Car> copy = new ArrayList<>(this.carList);
        Collections.sort(copy);
        this.sortingUtility.bubbleSort(this.carList);
        assertThat(carList.equals(copy), is(true));
    }

    @Test
    public void testIntegerSort() {
        List<Integer> copy = new LinkedList<>(this.numberList);
        Collections.sort(copy);
        this.sortingUtility.bubbleSort(this.numberList);
        assertThat(numberList.equals(copy), is(true));
    }

    @Test
    public void testStringSort() {
        List<String> copy = new LinkedList<>(this.stringList);
        Collections.sort(copy);
        this.sortingUtility.bubbleSort(this.stringList);
        assertThat(stringList.equals(copy), is(true));
    }
}
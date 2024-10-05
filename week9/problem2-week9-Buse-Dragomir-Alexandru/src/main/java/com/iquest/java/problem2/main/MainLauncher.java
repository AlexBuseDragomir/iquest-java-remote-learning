package com.iquest.java.problem2.main;

import com.iquest.java.problem2.car.Car;
import com.iquest.java.problem2.utility.SortingUtility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Tesla", 43000));
        carList.add(new Car("Mazda", 27000));
        carList.add(new Car("Opel", 19500));
        carList.add(new Car("Subaru", 39000));
        carList.add(new Car("Mitsubishi", 31500));

        SortingUtility sortingUtility = new SortingUtility();
        System.out.println("Unsorted car collection:");
        sortingUtility.printCollection(carList);
        System.out.println();
        System.out.println("Sorted car collection:");
        sortingUtility.bubbleSort(carList);
        sortingUtility.printCollection(carList);
        System.out.println();

        List<Integer> numberList = new LinkedList<>();
        numberList.add(12);
        numberList.add(92);
        numberList.add(4);
        numberList.add(19);
        numberList.add(9);
        numberList.add(22);
        numberList.add(31);
        numberList.add(27);

        System.out.println("Unsorted Integer collection:");
        sortingUtility.printCollection(numberList);
        System.out.println();
        System.out.println("Sorted Integer collection:");
        sortingUtility.bubbleSort(numberList);
        sortingUtility.printCollection(numberList);
        System.out.println();

        List<String> stringList = new LinkedList<>();
        stringList.add("Maria");
        stringList.add("Joanna");
        stringList.add("Xenia");
        stringList.add("Anna");
        stringList.add("Haley");
        stringList.add("Diana");
        stringList.add("Amber");
        stringList.add("Layla");

        System.out.println("Unsorted String collection:");
        sortingUtility.printCollection(stringList);
        System.out.println();
        System.out.println("Sorted String collection:");
        sortingUtility.bubbleSort(stringList);
        sortingUtility.printCollection(stringList);
        System.out.println();
    }
}

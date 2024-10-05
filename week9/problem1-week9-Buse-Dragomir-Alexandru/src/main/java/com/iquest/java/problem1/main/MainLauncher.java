package com.iquest.java.problem1.main;

import com.iquest.java.problem1.car.Car;
import com.iquest.java.problem1.grocery.GroceryCart;
import com.iquest.java.problem1.parking.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        GroceryCart groceryCart = new GroceryCart();

        List<String> products = new ArrayList<>();
        products.add("coke");
        products.add("apples");
        products.add("tea");
        products.add("tomatoes");
        products.add("sugar");

        groceryCart.addProductsToCart(products);
        System.out.print("Products in shopping cart: ");
        groceryCart.printProductsFromCart();

        boolean areProductsInCart = groceryCart.checkIfProductsAreAdded(products);
        System.out.println();
        System.out.println("Have all products been added? " + areProductsInCart);

        //////////////////////////////////////////////////////////////////////////
        System.out.println();
        ParkingLot parkingLot = new ParkingLot();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", 43000));
        cars.add(new Car("Mazda", 27000));
        cars.add(new Car("Opel", 19500));
        cars.add(new Car("Subaru", 39000));
        cars.add(new Car("Mitsubishi", 31500));

        parkingLot.addCarsToParkingLot(cars);
        System.out.println("Cars in parking lot: ");
        parkingLot.printCarsFromParkingLot();

        boolean areCarsInParkingLot = parkingLot.checkIfCarsAreAdded(cars);
        System.out.println();
        System.out.println("Are all cars in the parking lot? " + areCarsInParkingLot);
        System.out.println();

        cars.add(new Car("Dacia", 9500));
        System.out.println("A Dacia car has been added to the cars list");
        areCarsInParkingLot = parkingLot.checkIfCarsAreAdded(cars);
        System.out.println("Are all cars in the parking lot? " + areCarsInParkingLot);
    }
}

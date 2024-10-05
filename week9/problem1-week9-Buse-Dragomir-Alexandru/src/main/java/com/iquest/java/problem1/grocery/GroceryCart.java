package com.iquest.java.problem1.grocery;

import com.iquest.java.problem1.collection.MyCollection;
import com.iquest.java.problem1.implementation.SimpleCollection;

import java.util.List;

public class GroceryCart {

    private MyCollection<String> shoppingCart;

    public GroceryCart() {
        this.shoppingCart = new SimpleCollection<>(new String[0]);
    }

    public boolean addProductsToCart(List<String> products) {
        return shoppingCart.addAll(products);
    }

    public boolean checkIfProductsAreAdded(List<String> products) {
        return shoppingCart.containsAll(products);
    }

    public void printProductsFromCart() {
        String[] products = this.shoppingCart.getElements();
        for (String product: products) {
            System.out.print(product + " ");
        }
    }
}

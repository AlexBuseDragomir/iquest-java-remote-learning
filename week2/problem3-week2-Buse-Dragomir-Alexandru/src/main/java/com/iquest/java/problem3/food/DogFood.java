package com.iquest.java.problem3.food;

public class DogFood {

    private String foodName;

    public DogFood(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return this.foodName;
    }

    @Override
    public String toString() {
        return this.foodName;
    }
}

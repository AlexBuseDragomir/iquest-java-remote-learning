package com.iquest.java.problem3.inheritance;

import com.iquest.java.problem3.food.DogFood;

@SuppressWarnings("FieldCanBeLocal")
public class SledDog extends Dog {

    private static String utility;
    private String regionOfOrigin;
    private DogFood sledDogFood;

    static {
        utility = "transport on snow";
        System.out.println("STATIC BLOCK -> Sled dog utility: " +
                utility);
    }

    {
        this.regionOfOrigin = "Siberia";
        System.out.println("NON-STATIC BLOCK -> Sled dog region of origin: " +
                this.regionOfOrigin);
    }

    public SledDog() {
        super();
        System.out.println("CONSTRUCTOR call for SledDog");
        this.sledDogFood = new DogFood("dry fish");
        System.out.println("OBJECT MEMBER IN SLED DOG: The sled dog eats " + this.sledDogFood);
    }
}

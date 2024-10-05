package com.iquest.java.problem3.inheritance;

import com.iquest.java.problem3.food.DogFood;

@SuppressWarnings("FieldCanBeLocal")
public class Dog extends Animal {

    private static String scientificName;
    private String breed;
    private DogFood simpleDogFood;

    static {
        scientificName = "Canis lupus familiaris";
        System.out.println("STATIC BLOCK -> Dog scientific name: " +
                scientificName);
    }

    {
        this.breed = "Husky";
        System.out.println("NON-STATIC BLOCK -> Dog breed: " +
                this.breed);
    }

    public Dog() {
        super();
        System.out.println("CONSTRUCTOR call for Dog");
        this.simpleDogFood = new DogFood("Pedigree");
        System.out.println("OBJECT MEMBER IN DOG: The dog eats " + this.simpleDogFood);
    }
}

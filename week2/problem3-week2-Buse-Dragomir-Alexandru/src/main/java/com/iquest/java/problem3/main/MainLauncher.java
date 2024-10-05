package com.iquest.java.problem3.main;

import com.iquest.java.problem3.inheritance.Animal;
import com.iquest.java.problem3.inheritance.Dog;
import com.iquest.java.problem3.inheritance.SledDog;

public class MainLauncher {

    @SuppressWarnings("UnusedDeclaration")
    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println();
        Dog dog = new Dog();
        System.out.println();
        SledDog sledDog = new SledDog();
    }
}

package com.iquest.java.problem1.main;

import com.iquest.java.problem1.person.Person;

public class MainLauncher {

    public static void main(String[] args) {

        Person firstPerson = new Person("Kate Nichole Alice", "Roberts");
        Person secondPerson = new Person("Kate Nichole Alice Roberts");

        System.out.println("Using the first constructor:");
        System.out.println(firstPerson);

        System.out.println("\nUsing the second constructor:");
        System.out.println(secondPerson);
    }
}

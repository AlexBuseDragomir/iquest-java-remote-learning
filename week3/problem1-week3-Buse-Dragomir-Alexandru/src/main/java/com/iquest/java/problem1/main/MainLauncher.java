package com.iquest.java.problem1.main;

import com.iquest.java.problem1.person.AmericanPerson;
import com.iquest.java.problem1.person.FrenchPerson;

import java.time.LocalDate;

public class MainLauncher {

    public static void main(String[] args) {

        LocalDate birthDateOfAmerican = LocalDate.of(1996, 11, 25);
        LocalDate birthDateOfFrench = LocalDate.of(1992, 7, 12);

        AmericanPerson americanPerson = new AmericanPerson("Merry", "Stevens", birthDateOfAmerican);
        System.out.println(americanPerson.selfDescribe());

        System.out.println();

        FrenchPerson frenchPerson = new FrenchPerson("Diane", "Alarie", birthDateOfFrench);
        System.out.println(frenchPerson.selfDescribe());
    }
}

package com.iquest.java.problem1.person;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private String firstName;
    private String surname;

    public abstract String getBirthDate();
    public abstract String selfDescribe();

    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public Person(String fullName) {
        this.splitNameInForenameAndSurname(fullName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurname() {
        return this.surname;
    }

    public int calculatePersonAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private void splitNameInForenameAndSurname(String fullName) {
        String[] personNames = fullName.split(" ");
        StringBuilder firstNameBuilder = new StringBuilder();

        for (int index = 0; index < personNames.length - 1; index ++) {
            if (index < personNames.length - 2) {
                firstNameBuilder.append(personNames[index]);
                firstNameBuilder.append(" ");
            } else {
                firstNameBuilder.append(personNames[index]);
            }
        }

        this.firstName = firstNameBuilder.toString();
        this.surname = personNames[personNames.length - 1];
    }

    @Override
    public String toString() {
        return "First name/s: " + this.getFirstName() + "\n" +
                "Last name: " + this.getSurname();
    }
}

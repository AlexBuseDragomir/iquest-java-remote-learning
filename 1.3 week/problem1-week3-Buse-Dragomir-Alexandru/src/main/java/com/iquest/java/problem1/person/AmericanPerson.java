package com.iquest.java.problem1.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AmericanPerson extends Person {

    private LocalDate birthDate;

    public AmericanPerson(String firstName, String surname, LocalDate birthDate) {
        super(firstName, surname);
        this.birthDate = birthDate;
    }

    public String selfDescribe() {
        return "Hello, my name is " + this.getFirstName() + " " + this.getSurname() +
                "\nI come from America and I am " + this.calculatePersonAge(this.birthDate) +
                " years old." + "\nMy birth date is " + this.getBirthDate();
    }

    public String getBirthDate() {
        return this.birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}

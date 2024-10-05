package com.iquest.java.problem1.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrenchPerson extends Person {

    private LocalDate birthDate;

    public FrenchPerson(String firstName, String surname, LocalDate birthDate) {
        super(firstName, surname);
        this.birthDate = birthDate;
    }

    public String selfDescribe() {
        return "Bonjour, mon nom est " + this.getFirstName() + " " + this.getSurname() +
                "\nJe viens de France et j'ai " + this.calculatePersonAge(this.birthDate) +
                " ans." + "\nMa date de naissance est " + this.getBirthDate();
    }

    public String getBirthDate() {
        return this.birthDate.format(DateTimeFormatter.ofPattern("dd~MM~yyyy"));
    }
}

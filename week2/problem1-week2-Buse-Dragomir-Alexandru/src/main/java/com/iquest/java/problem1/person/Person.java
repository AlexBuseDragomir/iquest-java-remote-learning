package com.iquest.java.problem1.person;

public class Person {

    private String firstName;
    private String surname;

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

    @Override
    public String toString() {
        return "First name/s: " + this.getFirstName() + "\n" +
                "Last name: " + this.getSurname();
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
}

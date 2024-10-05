package main;

import utility.PersonUtility;

import java.util.ArrayList;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        List<String> persons = new ArrayList<>();
        persons.add("18:Jane");
        persons.add("18:Simone");
        persons.add("17:John");
        persons.add("15:Marcel");
        persons.add("21:Andrew");
        persons.add("20:Abby");

        PersonUtility personUtility = new PersonUtility(persons);

        System.out.println("Persons older than 18 years:");
        personUtility.printPersonsOlderThan(18);

        System.out.println();

        System.out.print("The oldest person is: ");
        personUtility.printOldestPerson();

        System.out.println();

        System.out.print("Are all persons younger than 80? -> ");
        System.out.println(personUtility.areAllPersonsYoungerThan(80));

        System.out.print("Are all persons younger than 21? -> ");
        System.out.println(personUtility.areAllPersonsYoungerThan(21));

        System.out.println();

        personUtility.printPersonsGroupedByAge();
    }
}

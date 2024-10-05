package utility;

import person.Person;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class PersonUtility {

    private List<Person> listOfPersons;

    public PersonUtility(List<String> personsAsStrings) {
        this.listOfPersons = this.convertPersonStringsToList(personsAsStrings);
    }

    public void printPersonsOlderThan(int age) {
        this.listOfPersons.stream()
                .filter(person -> person.getAge() > age)
                .forEach(System.out::println);
    }

    public void printOldestPerson() {
        Optional<Person> oldest =
                this.listOfPersons.stream()
                    .max(Comparator.comparingInt(Person::getAge));

        oldest.ifPresent(System.out::println);
    }

    public boolean areAllPersonsYoungerThan(int age) {
        return this.listOfPersons.stream()
                .allMatch(person -> person.getAge() < age);
    }

    public void printPersonsGroupedByAge() {
        Map<Integer, List<Person>> personsPerAge =
                this.listOfPersons.stream()
                        .collect(groupingBy(Person::getAge));

        this.printPersonsFromMap(personsPerAge);
    }

    private List<Person> convertPersonStringsToList(List<String> persons) {
        List<Person> result = new ArrayList<>();

        for (String person: persons) {
            int age = Integer.parseInt(person.substring(0, 2));
            String name = person.substring(3);

            result.add(new Person(name, age));
        }

        return result;
    }

    private void printPersonsFromMap(Map<Integer, List<Person>> personsPerAge) {
        for (Map.Entry<Integer, List<Person>> entry : personsPerAge.entrySet()) {
            Integer age = entry.getKey();
            List<Person> personList = entry.getValue();
            System.out.print("With age " + age + " : " );

            for (Person person: personList) {
                System.out.print(person.getName() + " ");
            }

            System.out.println();
        }
    }
}

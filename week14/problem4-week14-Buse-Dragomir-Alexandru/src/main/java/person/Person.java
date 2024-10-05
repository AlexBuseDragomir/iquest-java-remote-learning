package person;

public class Person {

    private String name;
    private int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        if (this.hashCode() != person.hashCode()) {
            return false;
        } else {
            return this.name.equals(person.name) &&
                    this.age == person.age;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age;
    }

    @Override
    public String toString() {
        return this.getName() + " with age: " + this.getAge();
    }
}

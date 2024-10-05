package com.iquest.java.problem2.amphibians;

public abstract class Amphibian {

    private int bodySizeInCentimeters;
    private String typeOfHabitat;

    public Amphibian(int bodySizeInCentimeters, String typeOfHabitat) {
        this.bodySizeInCentimeters = bodySizeInCentimeters;
        this.typeOfHabitat = typeOfHabitat;
    }

    public abstract void moveForward(int distanceInCentimeters);
    public abstract void eatSomething(String insectToEatName);

    public String toString() {
        return "The amphibian has a body size of " + this.bodySizeInCentimeters + " cm " +
                "\nand lives in the following habitat: " + this.typeOfHabitat;
    }
}

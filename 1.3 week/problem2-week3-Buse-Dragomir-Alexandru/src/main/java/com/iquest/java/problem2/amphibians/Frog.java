package com.iquest.java.problem2.amphibians;

public class Frog extends Amphibian {

    private String typeOfFrog;
    private String scientificName;

    public Frog(int bodySizeInCentimeters, String typeOfHabitat, String typeOfFrog,
                String scientificName) {
        super(bodySizeInCentimeters, typeOfHabitat);
        this.typeOfFrog = typeOfFrog;
        this.scientificName = scientificName;
    }

    public void moveForward(int distanceInCentimeters) {
        System.out.println("The frog is moving forward " + distanceInCentimeters + " centimeters");
    }

    public void eatSomething(String insectToEatName) {
        System.out.println("The frog eats a " + insectToEatName);
    }

    public void makeASound(String frogSound) {
        System.out.println("The frog makes the following sound: " + frogSound);
    }

    public String toString() {
        return  super.toString() + "\n" +
                this.scientificName + " is a " + this.typeOfFrog + " frog\n";
    }
}

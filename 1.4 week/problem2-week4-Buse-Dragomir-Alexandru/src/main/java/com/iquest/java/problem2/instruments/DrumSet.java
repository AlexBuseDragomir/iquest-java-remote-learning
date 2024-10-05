package com.iquest.java.problem2.instruments;

public class DrumSet {

    private String drumSetType;
    private int drumSetPriceInDollars;

    public DrumSet(String drumSetType, int drumSetPrice) {
        this.drumSetType = drumSetType;
        this.drumSetPriceInDollars = drumSetPrice;
    }

    public void assembleDrumSet() {
        System.out.println("Assembling the " + this.getDrumSetType() +
                " drum set");
    }

    public String getDrumSetType() {
        return this.drumSetType;
    }

    @Override
    public String toString() {
        return this.drumSetType + " drum set worth $" +
                this.drumSetPriceInDollars;
    }
}

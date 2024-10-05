package com.iquest.java.problem2.instruments;

public class Guitar {

    private String guitarType;
    private String guitarColor;

    public Guitar(String guitarType, String guitarColor) {
        this.guitarType = guitarType;
        this.guitarColor = guitarColor;
    }

    public void tuneGuitar() {
        System.out.println("Tuning the " + this.guitarType + " guitar");
    }

    @Override
    public String toString() {
        return this.guitarColor + " " + this.guitarType + " guitar";
    }
}

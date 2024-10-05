package com.iquest.java.problem2.musicians.guitarist;

import com.iquest.java.problem2.instruments.Guitar;

public class LeadGuitarist implements Guitarist {

    private String name;
    private Guitar guitar;

    public LeadGuitarist(String name, Guitar guitar) {
        this.name = name;
        this.guitar = guitar;
    }

    @Override
    public void playGuitar() {
        System.out.println("Lead guitarist playing a " +
                this.guitar);
    }

    @Override
    public void tuneGuitar() {
        System.out.print("Lead guitarist: ");
        this.guitar.tuneGuitar();
    }

    @Override
    public String toString() {
        return "Lead guitarist " + this.name +
                " has a " + guitar;
    }
}

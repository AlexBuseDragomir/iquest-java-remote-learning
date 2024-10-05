package com.iquest.java.problem2.musicians.guitarist;

import com.iquest.java.problem2.instruments.Guitar;

public class BassGuitarist implements Guitarist {

    private String name;
    private Guitar guitar;

    public BassGuitarist(String name, Guitar guitar) {
        this.name = name;
        this.guitar = guitar;
    }

    @Override
    public void playGuitar() {
        System.out.println("Bass guitarist playing a " +
                this.guitar);
    }

    @Override
    public void tuneGuitar() {
        System.out.print("Bass guitarist: ");
        this.guitar.tuneGuitar();
    }

    @Override
    public String toString() {
        return "Bass guitarist " + this.name +
                " has a " + guitar;
    }
}

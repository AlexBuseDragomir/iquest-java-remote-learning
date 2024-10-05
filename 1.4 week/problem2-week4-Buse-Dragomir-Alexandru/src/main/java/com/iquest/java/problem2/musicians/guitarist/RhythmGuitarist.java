package com.iquest.java.problem2.musicians.guitarist;

import com.iquest.java.problem2.instruments.Guitar;

public class RhythmGuitarist implements Guitarist {

    private String name;
    private Guitar guitar;

    public RhythmGuitarist(String name, Guitar guitar) {
        this.name = name;
        this.guitar = guitar;
    }

    @Override
    public void playGuitar() {
        System.out.println("Rhythm guitarist playing a " +
                this.guitar);
    }

    @Override
    public void tuneGuitar() {
        System.out.print("Rhythm guitarist: ");
        this.guitar.tuneGuitar();
    }

    @Override
    public String toString() {
        return "Rhythm guitarist " + this.name +
                " has a " + guitar;
    }
}

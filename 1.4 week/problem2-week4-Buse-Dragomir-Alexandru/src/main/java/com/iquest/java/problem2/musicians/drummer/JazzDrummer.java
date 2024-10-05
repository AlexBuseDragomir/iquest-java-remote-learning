package com.iquest.java.problem2.musicians.drummer;

import com.iquest.java.problem2.instruments.DrumSet;

public class JazzDrummer implements Drummer {

    private String name;
    private DrumSet drumSet;

    public JazzDrummer(String name, DrumSet drumSet) {
        this.name = name;
        this.drumSet = drumSet;
    }

    @Override
    public void takeSticks() {
        System.out.println("Jazz drummer is taking the sticks for the " +
                this.drumSet.getDrumSetType() + " drum set");
    }

    @Override
    public void playDrums() {
        System.out.println("Jazz drummer playing a " +
                this.drumSet);
    }

    @Override
    public String toString() {
        return "Jazz drummer " + this.name +
                " has a " + drumSet;
    }
}

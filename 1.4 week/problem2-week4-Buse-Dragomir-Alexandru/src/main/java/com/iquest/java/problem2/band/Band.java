package com.iquest.java.problem2.band;

import com.iquest.java.problem2.musicians.drummer.Drummer;
import com.iquest.java.problem2.musicians.guitarist.Guitarist;

public class Band {

    private Drummer bandDrummer;
    private Guitarist bandGuitarist;

    public Band(Drummer bandDrummer, Guitarist bandGuitarist) {
        this.bandDrummer = bandDrummer;
        this.bandGuitarist = bandGuitarist;
    }

    public void performRehearsal() {
        System.out.println("The band is rehearsing for the big concert");
    }

    public void singAtTheConcert() {
        System.out.println("The band is on the stage and the fans " +
                "love their music");
    }

    @Override
    public String toString() {
        return "Band members: \n" +
                this.bandDrummer + "\n" +
                this.bandGuitarist + "\n";
    }
}

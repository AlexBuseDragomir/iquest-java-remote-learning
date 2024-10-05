package com.iquest.java.problem1.main;

import com.iquest.java.problem1.personality.PersonalitySet;
import java.io.IOException;

public class MainLauncher {

    public static void main(String[] args) {

        PersonalitySet personalitySet = new PersonalitySet();

        try {
            personalitySet.populatePersonalitySetFromFile();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        personalitySet.displayPersonalities();
    }
}

package com.iquest.java.problem1.personality;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PersonalitySet {

    private static final int MAX_NUMBER_OF_PERSONALITIES = 100;
    private String[] personalityDataArray;
    private Set<Personality> personalitySet;

    public PersonalitySet() {
        this.personalityDataArray = new String[MAX_NUMBER_OF_PERSONALITIES];
        this.personalitySet = new HashSet<Personality>();
    }

    private void populatePersonalityDataArrayFromFile() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String pathToFile  = classLoader.getResource("W1P1input.txt").getPath();
        this.personalityDataArray = ReadFromFile.readLinesFromTextFile(pathToFile);
    }

    public void populatePersonalitySetFromFile() throws IOException {
        this.populatePersonalityDataArrayFromFile();

        for (int index = 0; index < this.personalityDataArray.length; index ++) {
            Personality newPersonality;
            String[] personalityInformation = this.personalityDataArray[index].split(", ");

            if (personalityInformation.length == 3) {
                newPersonality = new Personality(personalityInformation[0], personalityInformation[1],
                        personalityInformation[2]);
            }else {
                newPersonality = new Personality(personalityInformation[0], personalityInformation[1],
                        personalityInformation[2], personalityInformation[3]);
            }

            this.personalitySet.add(newPersonality);
        }
    }

    public void displayPersonalities() {
        for(Personality personality : this.personalitySet) {
            System.out.println(personality);
        }
    }


}

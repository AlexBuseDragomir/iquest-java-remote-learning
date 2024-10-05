package com.iquest.java.problem2.reader;

import java.io.IOException;

public class ReaderUtility {

    public String[] getCopyFromFileIntoArray(String fileName)
            throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            String pathToFile  = classLoader.getResource(fileName).getPath();
            return ReadFromFile.readLinesFromTextFile(pathToFile);
        } catch(NullPointerException nle) {
            nle.printStackTrace();
            System.err.println("Could not get the file path");
        }
        return null;
    }
}

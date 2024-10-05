package com.iquest.java.problem3.titlelize;

public class SimpleTitlelizer {

    public static String titlelizeWord(String wordToTitlelize) {
        if (wordToTitlelize.length() == 1) {
            return wordToTitlelize.substring(0, 1).toUpperCase();
        } else {
            return wordToTitlelize.substring(0, 1).toUpperCase() +
                    wordToTitlelize.substring(1);
        }
    }
}

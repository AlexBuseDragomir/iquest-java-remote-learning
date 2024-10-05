package com.iquest.java.problem2.titlelizer;

import java.util.List;

public class SimpleTitlelizer implements Titlelizer {

    private List<String> wordsToIgnore;

    public SimpleTitlelizer(List<String> wordsToIgnore) {
        this.wordsToIgnore = wordsToIgnore;
    }

    @Override
    public String titlelize(String toTitlelize)
            throws  IllegalArgumentException{
        if (toTitlelize == null) {
            throw new IllegalArgumentException("The argument is null");
        }

        String[] words = this.splitStringIntoWords(toTitlelize);
        StringBuilder titlelizedResult = new StringBuilder();

        for (String word: words) {
            if (this.isWordValid(word)) {
                titlelizedResult.append(this.titlelizeWord(word));
            } else{
                titlelizedResult.append(word);
            }
            titlelizedResult.append(" ");
        }
        String result =  titlelizedResult.toString();
        return result.trim();
    }

    private String titlelizeWord(String wordToTitlelize) {
        if ( ! wordsToIgnore.contains(wordToTitlelize)) {
            if (wordToTitlelize.length() == 1) {
                return wordToTitlelize.substring(0, 1).toUpperCase();
            } else {
                return wordToTitlelize.substring(0, 1).toUpperCase() +
                        wordToTitlelize.substring(1);
            }
        } else {
            return wordToTitlelize;
        }
    }

    private String[] splitStringIntoWords(String stringToSplit) {
        return stringToSplit.split(" ");
    }

    private boolean isWordValid(String toCheck) {
        for (char character: toCheck.toCharArray()) {
            if (Character.isLetter(character)) {
                return true;
            }
        }
        return false;
    }
}

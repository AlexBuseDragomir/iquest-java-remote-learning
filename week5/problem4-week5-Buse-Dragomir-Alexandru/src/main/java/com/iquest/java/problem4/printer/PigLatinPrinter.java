package com.iquest.java.problem4.printer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PigLatinPrinter {

    public void printLatinSentence(String untranslatedSentence) {
        String[] untranslatedWords = this.splitSentenceInWords(untranslatedSentence);
        for (String untranslatedWord: untranslatedWords) {
            this.printLatinWord(untranslatedWord);
            System.out.print(" ");
        }
    }

    public String getLatinSentence(String untranslatedSentence) {
        String[] untranslatedWords = this.splitSentenceInWords(untranslatedSentence);
        StringBuilder pigLatinSentence = new StringBuilder();
        for (String untranslatedWord: untranslatedWords) {
            String translatedWord = this.getLatinWord(untranslatedWord);
            pigLatinSentence.append(translatedWord);
            pigLatinSentence.append(" ");
        }
        return pigLatinSentence.toString().trim();
    }

    private void printLatinWord(String untranslatedWord) {
        System.out.print(this.getLatinWord(untranslatedWord));
    }

    private String getLatinWord(String untranslatedWord) {
        return untranslatedWord.substring(1) +
                untranslatedWord.substring(0, 1) + "ay";
    }

    private String[] splitSentenceInWords(String sentenceToSplit) {
        StringTokenizer tokenizer = new StringTokenizer(sentenceToSplit);
        List<String> words = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        return words.toArray(new String[0]);
    }
}

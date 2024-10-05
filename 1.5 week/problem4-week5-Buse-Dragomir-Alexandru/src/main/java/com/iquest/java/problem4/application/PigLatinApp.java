package com.iquest.java.problem4.application;

import com.iquest.java.problem4.printer.PigLatinPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PigLatinApp {

    private final static int MAX_SENTENCE_COUNT = 10;
    private List<String> allTranslatedSentences;

    public PigLatinApp() {
        this.allTranslatedSentences = new ArrayList<>();
    }

    public void startPigLatinTranslator() {
        int i = 0;
        Scanner reader = new Scanner(System.in);
        PigLatinPrinter pigLatinPrinter = new PigLatinPrinter();
        System.out.println("Welcome to the pig latin translator!");
        while(i < MAX_SENTENCE_COUNT) {
            System.out.println("\nPlease insert your sentence: ");
            String sentence = reader.nextLine();
            System.out.println("Your translated sentence is: ");
            pigLatinPrinter.printLatinSentence(sentence);
            this.allTranslatedSentences.add(pigLatinPrinter.getLatinSentence(sentence));
            System.out.println("\n\nTranslations so far: ");
            for (String translation: this.allTranslatedSentences) {
                System.out.println(translation);
            }
            i ++;
            System.out.println("\nDo you want to continue? Enter Y to continue");
            System.out.println("Print any other key if you want to stop");
            String character = reader.nextLine();
            if ( ! character.equals("Y")) {
                break;
            }
            if (i == 9) {
                System.out.println("Maximum number of translations has been reached!");
            }
        }
    }
}

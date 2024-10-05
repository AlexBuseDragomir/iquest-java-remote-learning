package com.iquest.java.problem3.sentence;

import com.iquest.java.problem3.titlelize.SimpleTitlelizer;

import java.util.Random;

public class SingleSentenceGenerator implements SentenceGenerator {

    private Random random = new Random();

    @Override
    public String generateSentence(String[] articles, String[] nouns,
                                   String[] verbs, String[] prepositions) {
        String firstArticle = this.getWordFromRandomPosition(articles);
        String firstNoun = this.getWordFromRandomPosition(nouns);
        String secondArticle = this.getWordFromRandomPosition(articles);
        String secondNoun = this.getWordFromRandomPosition(nouns);
        String verb = this.getWordFromRandomPosition(verbs);
        String preposition = this.getWordFromRandomPosition(prepositions);
        String firstArticleTitlelized = SimpleTitlelizer.titlelizeWord(firstArticle);

        return firstArticleTitlelized + " " + firstNoun + " " + verb + " " + preposition +
                " " + secondArticle + " " + secondNoun + ".";
    }

    private String getWordFromRandomPosition(String[] arrayOfWords) {
        return arrayOfWords[this.random.nextInt(arrayOfWords.length)];
    }
}

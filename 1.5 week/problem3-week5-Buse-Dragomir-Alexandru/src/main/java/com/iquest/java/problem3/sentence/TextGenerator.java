package com.iquest.java.problem3.sentence;

public class TextGenerator {

    public String generateText(int numberOfSentences, String[] articles, String[] nouns,
                               String[] verbs, String[] prepositions) {
        StringBuilder textBuilder = new StringBuilder();
        SentenceGenerator sentenceGenerator = new SingleSentenceGenerator();

        for (int i = 0; i < numberOfSentences - 1; i ++) {
            String sentence = sentenceGenerator.generateSentence(articles, nouns, verbs, prepositions);
            textBuilder.append(sentence);
            textBuilder.append("\n");
        }

        String sentence = sentenceGenerator.generateSentence(articles, nouns, verbs, prepositions);
        textBuilder.append(sentence);

        return textBuilder.toString();
    }
}

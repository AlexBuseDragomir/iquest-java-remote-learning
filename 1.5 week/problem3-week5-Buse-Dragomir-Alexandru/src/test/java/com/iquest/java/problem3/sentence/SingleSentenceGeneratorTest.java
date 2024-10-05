package com.iquest.java.problem3.sentence;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SingleSentenceGeneratorTest {

    private SentenceGenerator singleSentenceGenerator;
    private String[] articles;
    private String[] nouns;
    private String[] verbs;
    private String[] prepositions;

    @Before
    public void setUp() {
        this.articles = new String[]{"the", "a", "one", "some", "any"};
        this.nouns = new String[]{"boy", "girl", "dog", "town", "car"};
        this.verbs = new String[]{"drove", "jumped", "ran", "walked", "skipped"};
        this.prepositions = new String[]{"to", "from", "over", "under", "on"};

        this.singleSentenceGenerator = new SingleSentenceGenerator();
    }

    @Test
    public void testWordOrderIsCorrect() {
        //WHEN
        String randomSentence = singleSentenceGenerator.
                generateSentence(this.articles, this.nouns, this.verbs, this.prepositions);

        String stringWithoutPeriod = randomSentence.substring(0,randomSentence.length() - 1);
        String stringLowercaseNoPeriod = stringWithoutPeriod.toLowerCase();
        //THEN
        String[] words = stringLowercaseNoPeriod.split(" ");
        assert(Arrays.asList(articles).contains(words[0]));
        assert(Arrays.asList(nouns).contains(words[1]));
        assert(Arrays.asList(verbs).contains(words[2]));
        assert(Arrays.asList(prepositions).contains(words[3]));
        assert(Arrays.asList(articles).contains(words[4]));
        assert(Arrays.asList(nouns).contains(words[5]));
    }

    @Test
    public void testEndingInPeriod() {
        //WHEN
        String randomSentence = singleSentenceGenerator.
                generateSentence(this.articles, this.nouns, this.verbs, this.prepositions);
        String lastCharacter = randomSentence.substring(randomSentence.length() - 1);
        //THEN
        assertThat(lastCharacter, is("."));
    }

    @Test
    public void testFirstLetterUppercase() {
        //WHEN
        String randomSentence = singleSentenceGenerator.
                generateSentence(this.articles, this.nouns, this.verbs, this.prepositions);
        //THEN
        assert(Character.isUpperCase(randomSentence.charAt(0)));
    }
}
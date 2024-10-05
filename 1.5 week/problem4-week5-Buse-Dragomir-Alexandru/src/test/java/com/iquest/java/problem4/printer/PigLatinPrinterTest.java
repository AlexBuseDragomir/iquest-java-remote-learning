package com.iquest.java.problem4.printer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PigLatinPrinterTest {

    private PigLatinPrinter pigLatinPrinter;

    @Before
    public void setUp() {
        this.pigLatinPrinter = new PigLatinPrinter();
    }

    @Test
    public void testSimpleSentence() {
        //WHEN
        String untranslatedSentence = "Simple sentence";
        String pigLatinSentence = pigLatinPrinter.getLatinSentence(untranslatedSentence);
        //THEN
        assertThat(pigLatinSentence, is("impleSay entencesay"));
    }

    @Test
    public void testEmptySentence() {
        //WHEN
        String untranslatedSentence = "";
        String pigLatinSentence = pigLatinPrinter.getLatinSentence(untranslatedSentence);
        //THEN
        assertThat(pigLatinSentence, is(""));
    }

    @Test
    public void testOneLetterSentence() {
        //WHEN
        String untranslatedSentence = "c";
        String pigLatinSentence = pigLatinPrinter.getLatinSentence(untranslatedSentence);
        //THEN
        assertThat(pigLatinSentence, is("cay"));
    }
}


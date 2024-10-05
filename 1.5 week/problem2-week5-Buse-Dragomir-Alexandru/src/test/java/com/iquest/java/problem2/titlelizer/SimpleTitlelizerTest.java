package com.iquest.java.problem2.titlelizer;

import com.iquest.java.problem2.reader.ReaderUtility;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleTitlelizerTest {

    private Titlelizer titlelizer;

    @Before
    public void setUp() {
        ReaderUtility readerUtility = new ReaderUtility();
        try {
            String[] wordsToIgnore = readerUtility.
                    getCopyFromFileIntoArray("WordsToIgnore.txt");
            titlelizer = new SimpleTitlelizer(Arrays.asList(wordsToIgnore));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitlelizeForNullShouldThrowException() throws Exception {
        titlelizer.titlelize(null);
    }

    @Test
    public void testTitlelizeForEmptyStringShouldReturnEmptyString() {
        //WHEN
        String actualResult = titlelizer.titlelize("");

        //THEN
        assertThat(actualResult, is(""));
    }

    @Test
    public void testTitlelizeForTitlelizedString() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("Already Titlelized String");

        //THEN
        assertThat(actualResult, is("Already Titlelized String"));
    }

    @Test
    public void testTitlelizeShouldIgnorePrepositionsString() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("This String is Titlelized");

        //THEN
        assertThat(actualResult, is("This String is Titlelized"));
    }

    @Test
    public void testTitlelizeWhenFirsWordIsPreposition() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("this String is Titlelized");

        //THEN
        assertThat(actualResult, is("This String is Titlelized"));
    }

    @Test
    public void testTitlelize() throws Exception {
        //WHEN
        String actualResult = titlelizer.titlelize("please titlelize me");

        //THEN
        assertThat(actualResult, is("Please Titlelize Me"));
    }
}
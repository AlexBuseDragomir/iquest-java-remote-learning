package com.iquest.java.problem3.utility;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileUtilityTest {

    private FileUtility fileUtility;
    private static final Charset ISO_LATIN_1 = Charset.forName("ISO-8859-1");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    @Before
    public void setUp() {
        this.fileUtility = new FileUtility();
    }

    @Test
    public void testConversionFromLatin1ToUtf8() {
        try {
            fileUtility.convertFileContentToEncoding("test1_latin1_input.txt",
                    UTF_8, "test1_utf8_output.txt");

            File inFile = this.fileUtility.getFileWithNameFromResources("test1_latin1_input.txt");
            File outFile = this.fileUtility.getFileWithNameFromResources("test1_utf8_output.txt");

            boolean areTheSame = FileUtils.contentEqualsIgnoreEOL(inFile, outFile, "ISO-8859-1");
            assertThat(areTheSame, is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = IOException.class)
    public void testConversionFromUtf8ToLatin1() throws  IOException {
        fileUtility.convertFileContentToEncoding("test2_utf8_input.txt",
                ISO_LATIN_1, "test2_latin1_output.txt");
    }
}
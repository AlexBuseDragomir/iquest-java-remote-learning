package com.iquest.java.problem2.utility;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileUtilityTest {

    private FileUtility fileUtility;
    private static final String FILE_NAME = "file.txt";
    private static final String ARCHIVE_NAME = "result.zip";

    @Before
    public void setUp() {
        this.fileUtility = new FileUtility();
    }

    @Test
    public void testCompressingFile() {
        try {
            this.fileUtility.compressFileFromResources(FILE_NAME, ARCHIVE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileUtility.getFileWithNameFromResources(ARCHIVE_NAME);
    }

    @Test
    public void testCompressionRatio() {
        File file = this.fileUtility.getFileWithNameFromResources(FILE_NAME);
        File archive = this.fileUtility.getFileWithNameFromResources(ARCHIVE_NAME);
        double compressionRatio = this.fileUtility.getCompressionRatio(file, archive);
        assert(compressionRatio > 1);
    }
}
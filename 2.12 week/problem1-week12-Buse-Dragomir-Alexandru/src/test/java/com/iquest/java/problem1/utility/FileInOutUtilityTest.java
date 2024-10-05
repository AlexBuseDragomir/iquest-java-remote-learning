package com.iquest.java.problem1.utility;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FileInOutUtilityTest {

    private FileInOutUtility fileInOutUtility;
    private File file;

    @Before
    public void setUp() {
        fileInOutUtility = new FileInOutUtility();
        this.file = fileInOutUtility.getFileWithNameFromResources("file.txt");
    }

    @Test
    public void testAddingIntegersToFile() {
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;
        int fourthValue = 4;
        try {
            fileInOutUtility.writeIntegerToFileInPosition(this.file, 0, firstValue);
            fileInOutUtility.writeIntegerToFileInPosition(this.file, 1, secondValue);
            fileInOutUtility.writeIntegerToFileInPosition(this.file, 2, thirdValue);
            fileInOutUtility.writeIntegerToFileInPosition(this.file, 3, fourthValue);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Test
    public void testReadingFileWithRandomAccess() {
        int firstValue = 1;
        int secondValue = 2;
        int thirdValue = 3;
        int fourthValue = 4;
        try {
            int readFirstValue = fileInOutUtility.readIntegerFromPositionInFile(this.file, 0);
            int readSecondValue = fileInOutUtility.readIntegerFromPositionInFile(this.file, 1);
            int readThirdValue = fileInOutUtility.readIntegerFromPositionInFile(this.file, 2);
            int readFourthValue = fileInOutUtility.readIntegerFromPositionInFile(this.file, 3);

            fileInOutUtility.clearFileContent(this.file);

            assertThat(readFirstValue, is(firstValue));
            assertThat(readSecondValue, is(secondValue));
            assertThat(readThirdValue, is(thirdValue));
            assertThat(readFourthValue, is(fourthValue));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
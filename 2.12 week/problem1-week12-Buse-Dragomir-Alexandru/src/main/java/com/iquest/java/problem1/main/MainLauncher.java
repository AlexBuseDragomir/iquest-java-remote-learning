package com.iquest.java.problem1.main;

import com.iquest.java.problem1.utility.FileInOutUtility;

import java.io.File;
import java.io.IOException;

public class MainLauncher {

    public static void main(String[] args) {

        FileInOutUtility fileInOutUtility = new FileInOutUtility();
        File file = fileInOutUtility.getFileWithNameFromResources("file.txt");
        try {
            fileInOutUtility.writeIntegerToFileInPosition(file, 0, 1);
            fileInOutUtility.writeIntegerToFileInPosition(file, 1, 2);
            fileInOutUtility.writeIntegerToFileInPosition(file, 2, 3);
            fileInOutUtility.writeIntegerToFileInPosition(file, 3, 4);

            int thirdValue = fileInOutUtility.readIntegerFromPositionInFile(file, 2);
            int fourthValue = fileInOutUtility.readIntegerFromPositionInFile(file, 3);

            System.out.println("Third value is " + thirdValue);
            System.out.println("Fourth value is " + fourthValue);

            fileInOutUtility.clearFileContent(file);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

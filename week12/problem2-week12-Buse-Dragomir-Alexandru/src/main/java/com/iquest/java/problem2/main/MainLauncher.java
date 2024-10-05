package com.iquest.java.problem2.main;

import com.iquest.java.problem2.utility.FileUtility;

import java.io.File;
import java.io.IOException;

public class MainLauncher {

    public static void main(String[] args) {

        FileUtility fileUtility = new FileUtility();

        try {
            fileUtility.compressFileFromResources("file.txt", "result.zip");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        File initialFile = fileUtility.getFileWithNameFromResources("file.txt");
        File compressedFile = fileUtility.getFileWithNameFromResources("result.zip");
        System.out.println("Initial file length is " + initialFile.length() + " bytes");
        System.out.println("Compressed file length is " + compressedFile.length() + " bytes");
        double compressionRate = fileUtility.getCompressionRatio(initialFile, compressedFile);
        System.out.println("The compression rate is " + compressionRate);
    }
}

package main;

import utility.FileUtility;

import java.io.File;

public class MainLauncher {

    public static void main(String[] args) {

        FileUtility fileUtility = new FileUtility();

        File[] subdirectories1 = fileUtility.getSubdirectories1("parent");
        File[] subdirectories2 =  fileUtility.getSubdirectories2("parent");

        System.out.println("Using the lambda version:");
        fileUtility.listFileNames(subdirectories1);
        System.out.println();
        System.out.println("Using the function reference version:");
        fileUtility.listFileNames(subdirectories2);
    }
}

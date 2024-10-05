package com.iquest.java.week6.problem3.utility;

public class StringUtility {

    public static String extractClassNameFromFullName(String fullyQualifiedName) {
        String[] fullyQualifiedNamePieces = fullyQualifiedName.split("\\.");
        int pathLength = fullyQualifiedNamePieces.length;
        return fullyQualifiedNamePieces[pathLength - 1];
    }
}
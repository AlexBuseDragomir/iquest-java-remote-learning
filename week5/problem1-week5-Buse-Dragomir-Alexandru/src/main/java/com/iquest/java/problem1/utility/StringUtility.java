package com.iquest.java.problem1.utility;

import java.util.Arrays;
import java.util.List;

public class StringUtility {

    public static boolean isStringIntegerNumber(String toCheck) {
        Character[] numberArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Character> charNumbers = Arrays.asList(numberArray);
        for (char character : toCheck.toCharArray()) {
            if ( ! charNumbers.contains(character)) {
                return false;
            }
        }
        return toCheck.toCharArray()[0] != '0';
    }
}

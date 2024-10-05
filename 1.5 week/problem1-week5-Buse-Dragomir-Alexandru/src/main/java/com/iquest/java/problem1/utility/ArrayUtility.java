package com.iquest.java.problem1.utility;

public class ArrayUtility {

    public static int[] getArrayCopyWithIncreasedSize(int[] arrayToCopy, int sizeIncrease) {
        int[] newArray = new int[arrayToCopy.length + sizeIncrease];
        System.arraycopy( arrayToCopy, 0, newArray, 0, arrayToCopy.length );
        return newArray;
    }
}

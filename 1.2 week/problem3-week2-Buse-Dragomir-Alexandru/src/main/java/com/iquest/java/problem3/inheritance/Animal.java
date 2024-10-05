package com.iquest.java.problem3.inheritance;

@SuppressWarnings("FieldCanBeLocal")
public class Animal {

    private static String cellularStructure;
    private int bodySizeInCentimeters;

    static {
        cellularStructure = "multicellular";
        System.out.println("STATIC BLOCK -> Animal cellular structure: " +
                            cellularStructure);
    }

    {
        this.bodySizeInCentimeters = 100;
        System.out.println("NON-STATIC BLOCK -> Animal body size: " +
                            this.bodySizeInCentimeters);
    }

    public Animal() {
        System.out.println("CONSTRUCTOR call for Animal");
    }
}

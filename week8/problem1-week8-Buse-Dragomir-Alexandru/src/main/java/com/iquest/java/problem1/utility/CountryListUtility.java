package com.iquest.java.problem1.utility;

import com.iquest.java.problem1.country.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryListUtility {

    public <T extends Country> void printList(List<T> listToPrint) {
        for (T element: listToPrint) {
            System.out.println(element);
        }
    }

    public <T extends Country> List<String> extractCountryNames(List<T> listToExtractFrom) {
        List<String> resultedList = new ArrayList<>();
        for (Country country: listToExtractFrom) {
            resultedList.add(country.getName());
        }
        return resultedList;
    }

    public <T extends Country> List<String> extractCountryCapitals(List<T> listToExtractFrom) {
        List<String> resultedList = new ArrayList<>();
        for (Country country: listToExtractFrom) {
            resultedList.add(country.getCapital());
        }
        return resultedList;
    }
}

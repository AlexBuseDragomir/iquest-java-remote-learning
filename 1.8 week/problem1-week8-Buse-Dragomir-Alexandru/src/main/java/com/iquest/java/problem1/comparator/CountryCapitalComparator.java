package com.iquest.java.problem1.comparator;

import com.iquest.java.problem1.country.Country;

import java.util.Comparator;

public class CountryCapitalComparator implements Comparator<Country> {

    @Override
    public int compare(Country firstCountry, Country secondCountry) {
        return firstCountry.getCapital().compareTo(secondCountry.getCapital());
    }
}

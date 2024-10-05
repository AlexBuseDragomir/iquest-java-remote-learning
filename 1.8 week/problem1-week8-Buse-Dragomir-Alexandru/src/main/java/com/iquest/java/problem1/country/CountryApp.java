package com.iquest.java.problem1.country;

import com.iquest.java.problem1.comparator.CountryCapitalComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryApp {
    
    public <T extends Country> void sortListOfCountriesByName(List<T> countryList) {
        Collections.sort(countryList);
    }

    public <T extends Country> void sortListOfCountriesByCapital(List<T> countryList,
                                                                        Comparator<Country> countryComparator) {
        countryList.sort(countryComparator);
    }

    public <T extends Country> String findCountryThatHasCapital(List<T> countryList,
                                                                         String countryCapital) {
        countryList.sort(new CountryCapitalComparator());
        Country countryTemplateToSearch = new Country("", countryCapital);
        int position = Collections.binarySearch(countryList, countryTemplateToSearch ,
                new CountryCapitalComparator());
        return countryList.get(position).getName();
    }
}

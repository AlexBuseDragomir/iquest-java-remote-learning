package com.iquest.java.problem1.main;

import com.iquest.java.problem1.comparator.CountryCapitalComparator;
import com.iquest.java.problem1.country.Country;
import com.iquest.java.problem1.country.CountryApp;
import com.iquest.java.problem1.utility.CountryListUtility;

import java.util.ArrayList;
import java.util.List;

public class MainLauncher {

    public static void main(String[] args) {

        List<Country> countryList = new ArrayList<>();
        CountryListUtility countryListUtility = new CountryListUtility();
        CountryApp countryApp = new CountryApp();

        countryList.add(new Country("Namibia", "Windhoek"));
        countryList.add(new Country("Brazil", "Brasilia"));
        countryList.add(new Country("Paraguay", "Asuncion"));
        countryList.add(new Country("Peru", "Lima"));
        countryList.add(new Country("Mauritania", "Nouakchott"));
        countryList.add(new Country("Australia", "Canberra"));
        countryList.add(new Country("Chile", "Santiago"));
        countryList.add(new Country("Austria", "Vienna"));
        countryList.add(new Country("Indonesia", "Jakarta"));
        countryList.add(new Country("Japan", "Tokyo"));
        countryList.add(new Country("Uruguay", "Montevideo"));
        countryList.add(new Country("France", "Paris"));

        countryApp.sortListOfCountriesByName(countryList);
        System.out.println("SORTING BY NAME:");
        countryListUtility.printList(countryList);
        System.out.println();
        System.out.println("SORTING BY CAPITAL:");
        countryApp.sortListOfCountriesByCapital(countryList, new CountryCapitalComparator());
        countryListUtility.printList(countryList);
        System.out.println();
        System.out.print("COUNTRY WITH CAPITAL IN PARIS: ");
        System.out.print(countryApp.findCountryThatHasCapital(countryList, "Paris"));
        System.out.println();
    }
}

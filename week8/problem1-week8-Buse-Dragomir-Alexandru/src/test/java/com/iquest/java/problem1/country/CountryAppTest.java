package com.iquest.java.problem1.country;

import com.iquest.java.problem1.comparator.CountryCapitalComparator;
import com.iquest.java.problem1.utility.CountryListUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CountryAppTest {

    private List<Country> countryList;
    private List<String> wellSortedCountryNames;
    private List<String> wellSortedCountryCapitals;
    private CountryListUtility countryListUtility;
    private CountryApp countryApp;

    @Before
    public void setUp() {
        this.countryList = new ArrayList<>();
        this.wellSortedCountryNames = new ArrayList<>();
        this.wellSortedCountryCapitals = new ArrayList<>();
        this.countryListUtility = new CountryListUtility();
        this.countryApp = new CountryApp();

        this.countryList.add(new Country("Namibia", "Windhoek"));
        this.countryList.add(new Country("Brazil", "Brasilia"));
        this.countryList.add(new Country("Paraguay", "Asuncion"));
        this.countryList.add(new Country("Peru", "Lima"));
        this.countryList.add(new Country("Mauritania", "Nouakchott"));
        this.countryList.add(new Country("Australia", "Canberra"));
        this.countryList.add(new Country("Chile", "Santiago"));
        this.countryList.add(new Country("Austria", "Vienna"));
        this.countryList.add(new Country("Indonesia", "Jakarta"));
        this.countryList.add(new Country("Japan", "Tokyo"));
        this.countryList.add(new Country("Uruguay", "Montevideo"));
        this.countryList.add(new Country("France", "Paris"));

        this.wellSortedCountryNames = countryListUtility.extractCountryNames(this.countryList);
        this.wellSortedCountryCapitals = countryListUtility.extractCountryCapitals(this.countryList);
        Collections.sort(wellSortedCountryNames);
        Collections.sort(wellSortedCountryCapitals);
    }

    @Test
    public void testSortingByNameUsingCompareTo() {
        // WHEN
        countryApp.sortListOfCountriesByName(this.countryList);
        List<String> countryNamesAfterSort = countryListUtility.extractCountryNames(countryList);
        // THEN
        boolean equalResultFlag = countryNamesAfterSort.equals(wellSortedCountryNames);
        assertThat(equalResultFlag, is(true));
    }

    @Test
    public void testSortingByCapitalUsingComparator() {
        // WHEN
        countryApp.sortListOfCountriesByCapital(this.countryList, new CountryCapitalComparator());
        List<String> countryCapitalsAfterSort = countryListUtility.extractCountryCapitals(countryList);
        // THEN
        boolean equalResultFlag = countryCapitalsAfterSort.equals(wellSortedCountryCapitals);
        assertThat(equalResultFlag, is(true));
    }

    @Test
    public void testSearchingForCountryWithAGivenCapital() {
        // WHEN
        countryApp.sortListOfCountriesByCapital(this.countryList, new CountryCapitalComparator());
        String countryCapital1 = "Paris";
        String countryCapital2 = "Asuncion";
        String countryCapital3 = "Jakarta";
        String countryName1 = countryApp.findCountryThatHasCapital(this.countryList, countryCapital1);
        String countryName2 = countryApp.findCountryThatHasCapital(this.countryList, countryCapital2);
        String countryName3 = countryApp.findCountryThatHasCapital(this.countryList, countryCapital3);
        // THEN
        assertThat(countryName1, is("France"));
        assertThat(countryName2, is("Paraguay"));
        assertThat(countryName3, is("Indonesia"));
    }
}
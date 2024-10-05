package com.iquest.java.problem1.country;

public class Country implements Comparable<Country> {

    private String name;
    private String capital;

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    @Override
    public int compareTo(Country country) {
        return this.name.compareTo(country.getName());
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    @Override
    public String toString() {
        return "Country with name: " + this.name +
                " and capital: " + this.capital;
    }
}

package org.example;

public class Producer {
    private final String name;
    private final Country country;

    Producer(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "(" + country.countryName + ")";
    }
}

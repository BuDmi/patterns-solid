package org.example;

public enum Country {
    RUS("Russia"), GB("Great Britain"), GER("Germany"), USA("United States of America");

    public final String countryName;

    Country(String countryName) {
        this.countryName = countryName;
    }
}

// package continent;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String continentName;
    private double area;
    private List<Country> countries;

    public Continent(String continentName, double area) {
        this.continentName = continentName;
        this.area = area;
        this.countries = new ArrayList<>();
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public String toString() {
        return continentName + " (Area: " + area + " km²)\nCountries: " + countries;
    }
}

package SirMoseenPrograms.continent;
import java.util.ArrayList;

public class Country {
    private String countryName;
    private double countryArea;
    private double countryPopulation;
    private ArrayList<City> cities = new ArrayList<>();

    public Country(String countryName, double countryArea, City... acities) {
        this.countryName = countryName;
        this.countryArea = countryArea;
        this.countryPopulation = 0;
        addCities(acities);
    }

    public void addCity(City city) {
        city.setLocation(this);
        cities.add(city);
        calculatePopulation();
    }
    public void addCities(City... acities) {
        for (City city : acities) {
            addCity(city);
        }
    }

    public void calculatePopulation() {
        countryPopulation = 0; 
        for (City c : cities) {
            countryPopulation += c.getCityPopulation();
        }
    }

    public String getCountryName() {
        return countryName;
    }

    public double getCountryPopulation() {
        return countryPopulation;
    }

    @Override
    public String toString() {
        return "Country Name: " + countryName + "\nCountry Area: "
                + countryArea + "\nCountry Population: " + countryPopulation;
    }
}

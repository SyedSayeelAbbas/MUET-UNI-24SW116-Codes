// package continent;
public class City {
    private String cityName;
    private double cityPopulation;
    private Country location;

    public City(String cityName, double cityPopulation) {
        this.cityName = cityName;
        this.cityPopulation = cityPopulation;
        this.location = null; // Explicitly initialize to null
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityPopulation(double cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public String getCityName() {
        return cityName;
    }

    public double getCityPopulation() {
        return cityPopulation;
    }

    public Country getLocation() {
        return location;
    }

    public void setLocation(Country location) {
        this.location = location;
    }

    @Override
    public String toString() {
        String countryInfo = (location != null) ? location.getCountryName() : "Not specified";
        return "City Name: " + cityName + "\nCity Population: " + cityPopulation
                + "\nCity Located In: " + countryInfo;
    }
}

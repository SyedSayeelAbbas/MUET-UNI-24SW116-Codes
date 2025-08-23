public class City {
    private String cityName;
    private double cityPopulation;
    private Country location;

    public City(String cityName, double cityPopulation) {
        this.cityName = cityName;
        this.cityPopulation = cityPopulation;
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

    public double getCityPopulation() {  // Should return double
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
        return "City Name: " + cityName + "\nCity Population: " + cityPopulation
                + "\nCity Located In: " + location.getCountryName();
    }
}

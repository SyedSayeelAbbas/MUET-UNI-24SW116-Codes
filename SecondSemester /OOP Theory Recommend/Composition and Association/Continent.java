package SirMoseenPrograms.continent;
import java.util.ArrayList;

public class Continent {
    private String continentName;
    private double continentArea;
    private ArrayList<Country> countries = new ArrayList<>();

    public Continent(String continentName, double continentArea, Country... countries) {
        this.continentName = continentName;
        this.continentArea = continentArea;
        addCountries(countries);
    }

    public void addCountry(Country country) {
        if (country != null) {
            countries.add(country);
        }
    }

    public void addCountries(Country... countries) {
        for (Country country : countries) {
            addCountry(country);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continent Name: ").append(continentName).append("\n");
        sb.append("Continent Area: ").append(continentArea).append("\n");
        sb.append("Countries: \n");
        for (Country country : countries) {
            sb.append(country).append("\n");
        }
        return sb.toString();
    }
}

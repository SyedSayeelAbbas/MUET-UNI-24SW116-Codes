package SirMoseenPrograms.continent;

public class MainContinent {
    public static void main(String[] args) {
//        // Asia
//        Country pakistan = new Country("Pakistan", 881_913);
//        pakistan.addCity(new City("Hyderabad", 1_000_000));
//        pakistan.addCity(new City("Karachi", 15_000_000));
//        pakistan.addCity(new City("Lahore", 11_000_000));
//        pakistan.addCity(new City("Islamabad", 1_200_000));
//        pakistan.addCity(new City("Quetta", 1_000_000));
//
//        Country india = new Country("India", 3_287_263);
//        india.addCity(new City("Mumbai", 20_000_000));
//        india.addCity(new City("Delhi", 18_000_000));
//        india.addCity(new City("Bangalore", 12_000_000));
//        india.addCity(new City("Hyderabad", 10_000_000));
//        india.addCity(new City("Chennai", 9_000_000));
//
////        Continent asia = new Continent("Asia",1000);
////        asia.addCountry(pakistan);
////        asia.addCountry(india);
//
//        // Europe
//        Country france = new Country("France", 551_695);
//        france.addCity(new City("Paris", 2_148_000));
//        france.addCity(new City("Marseille", 870_000));
//        france.addCity(new City("Lyon", 513_000));
//        france.addCity(new City("Toulouse", 471_000));
//        france.addCity(new City("Nice", 340_000));
//
////        Continent europe = new Continent("Europe",1000);
////        europe.addCountry(france);
//
//        // North America
//        Country usa = new Country("USA", 9_834_000);
//        usa.addCity(new City("New York", 8_400_000));
//        usa.addCity(new City("Los Angeles", 3_900_000));
//        usa.addCity(new City("Chicago", 2_700_000));
//        usa.addCity(new City("Houston", 2_300_000));
//        usa.addCity(new City("Phoenix", 1_600_000));

        //TESTING
        Continent c1=new Continent("M",1287478323,
                (new Country("pakistan",1234,
                        (new City("hyd",145)))));
        System.out.println(c1);

//        Continent northAmerica = new Continent("North America",1000);
//        northAmerica.addCountry(usa);
//
//        // Print all continents
//        System.out.println(asia);
//        System.out.println(europe);
//        System.out.println(northAmerica);
    }
}

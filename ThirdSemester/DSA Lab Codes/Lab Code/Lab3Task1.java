package SirNaveen;
/*
Task:
Create a class `Countries` that stores information about countries such as
name, area, and postal code. The class should:
1. Store up to 5 countries in a static array.
2. Provide a method to add new countries into the array.
3. Provide a method to display all stored countries.
4. Override `toString()` to show country details.
5. Implement a sorting method `countrySort()` that sorts countries
   alphabetically based on the first character of their name using insertion sort.
6. Demonstrate the functionality in the `main` method by adding countries,
   displaying them, sorting them, and displaying again.
*/

class Countries {
    String name;
    int area;
    int PostalCode;

    static Countries[] Country = new Countries[5];
    static int size = 0;

    // Method to add a new country
    public static void add(Countries c) {
        if (size < Country.length) {
            Country[size++] = c;
        } else {
            System.out.println("Cannot add more countries. Array is full!");
        }
    }

    // Constructor
    public Countries(String name, int area, int postalCode) {
        this.name = name;
        this.area = area;
        PostalCode = postalCode;
    }

    // Method to display all countries
    public static void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(Country[i]);
        }
    }

    // toString method for printing object
    @Override
    public String toString() {
        return "Country Name: " + name + ", Area: " + area + ", Postal Code: " + PostalCode;
    }

    // Sorting countries alphabetically by first character of name
    public static void countrySort() {
        int n = size;
        for (int i = 1; i < n; i++) {
            Countries key = Country[i];
            int j = i - 1;
            while (j >= 0 && Country[j].name.charAt(0) > key.name.charAt(0)) {
                Country[j + 1] = Country[j];
                j = j - 1;
            }
            Country[j + 1] = key;
        }
    }
}

// Main class
public class Lab3Task1 {
    public static void main(String[] args) {
        // Adding countries
        Countries.add(new Countries("Pakistan", 881913, 74000));
        Countries.add(new Countries("India", 3287263, 110001));
        Countries.add(new Countries("China", 9596961, 100000));
        Countries.add(new Countries("Nepal", 147181, 44600));
        Countries.add(new Countries("Afghanistan", 652230, 1001));

        System.out.println("Before Sorting:");
        Countries.display();

        // Sort countries
        Countries.countrySort();

        System.out.println("\nAfter Sorting:");
        Countries.display();
    }
}


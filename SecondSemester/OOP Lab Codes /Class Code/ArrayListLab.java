// package SirNaveenTask;
import java.util.ArrayList;

public class ArrayListLab {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        // 1. Adding elements
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        System.out.println("After adding elements: " + names);

        // 2. Adding an element at a specific index
        names.add(1, "David");
        System.out.println("After adding at index 1: " + names);

        // 3. Getting an element
        String nameAtIndex2 = names.get(2);
        System.out.println("Element at index 2: " + nameAtIndex2);

        // 4. Setting (modifying) an element
        names.set(1, "Eve");
        System.out.println("After setting index 1: " + names);

        // 5. Removing an element by index
        names.remove(2);
        System.out.println("After removing index 2: " + names);

        // 6. Checking if an element exists
        boolean hasBob = names.contains("Bob");
        System.out.println("Contains 'Bob': " + hasBob);

        // 7. Finding the size of the ArrayList
        int size = names.size();
        System.out.println("Size of ArrayList: " + size);

        // 8. Iterating through the ArrayList
        System.out.println("Iterating over elements:");
        for (String name : names) {
            System.out.println(name);
        }

        // 9. Clearing all elements
        names.clear();
        System.out.println("After clearing: " + names);

        // 10. Checking if the ArrayList is empty
        boolean isEmpty = names.isEmpty();
        System.out.println("Is ArrayList empty?: " + isEmpty);

        // 13. Finding the index of an element
        int indexOfGrace = names.indexOf("Grace");
        System.out.println("Index of 'Grace': " + indexOfGrace);

        // 14. Converting ArrayList to an array
        String[] array = names.toArray(new String[0]);
        System.out.println("Array elements: ");
        for (String str : array) {
            System.out.println(str);
        }

        // 13. Cloning the ArrayList
        ArrayList<String> clonedList = (ArrayList<String>) names.clone();
        System.out.println("Cloned list: " + clonedList);

        // 12. Adding multiple elements at once
        names.add("Frank");
        names.add("Grace");
        names.addAll(clonedList);
        System.out.println("After adding multiple elements: " + names);

    }
}


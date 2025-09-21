/*Q. No. 01
Develop a Linked structure containing searching, merging and displaying methods.
Now create two Linked structures and name them cars and trucks. 
The cars linked structure contains type of cars (sedan, hatchback, coupe, convertible, SUV, CUV, wagon, minivan) 
whereas, trucks contains (pickup, cargo, box, flatbed, dump, tanker and refrigerated).
Create a vehicles linked structure and merge data of cars and trucks in it using merge method.
Make use of search method to find whether vehicles structure contains ‘trailer’.
Also create an array which stores data of both cars and trucks linked structures
by concatenating ‘car’ keyword at the end of each car type and ‘truck’ at the end of each truck type
(array [‘sedan car’, ‘SUV car’, ‘cargo truck’]).
(10 Marks)
(CLO-2:C4, PLO-2)*/
public class LinkedStructure {
    LinkedStructure next;
    Object data;

    public LinkedStructure() {}

    public LinkedStructure(Object data) {
        this.data = data;
    }

    // Search method
    public boolean search(Object data) {
        for (LinkedStructure i = this; i != null; i = i.next) {
            if (i.data.equals(data)) return true;
        }
        return false;
    }

    // Merge method
    public LinkedStructure merge(LinkedStructure a, LinkedStructure b) {
        if (a == null) return b;
        if (b == null) return a;

        LinkedStructure p = a;
        while (p.next != null) {
            p = p.next;
        }
        p.next = b;
        return a;
    }

    // Display method
    public void display() {
        for (LinkedStructure p = this; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    // Count nodes
    public int count() {
        int count = 0;
        for (LinkedStructure p = this; p != null; p = p.next) {
            count++;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        // Cars
        LinkedStructure cars = new LinkedStructure("sedan");
        LinkedStructure car = cars;
        car.next = new LinkedStructure("hatchback");
        car.next.next = new LinkedStructure("coupe");
        car.next.next.next = new LinkedStructure("convertible");
        car.next.next.next.next = new LinkedStructure("SUV");
        car.next.next.next.next.next = new LinkedStructure("CUV");
        car.next.next.next.next.next.next = new LinkedStructure("miniVan");

        // Trucks
        LinkedStructure trucks = new LinkedStructure("pickUp");
        LinkedStructure truck = trucks;
        truck.next = new LinkedStructure("cargo");
        truck.next.next = new LinkedStructure("box");
        truck.next.next.next = new LinkedStructure("flatbed");
        truck.next.next.next.next = new LinkedStructure("dump");
        truck.next.next.next.next.next = new LinkedStructure("tanker");
        truck.next.next.next.next.next.next = new LinkedStructure("refrigerated");

        // Merge
        LinkedStructure vehicles = new LinkedStructure();
        vehicles = vehicles.merge(cars, trucks);

        // Search
        System.out.println("Search for 'trailer': " + vehicles.search("trailer"));

        // Array
        int length = cars.count() + trucks.count();
        Object[] array = new Object[length];

        LinkedStructure carPtr = cars;    // fresh pointer for cars
        LinkedStructure truckPtr = trucks; // fresh pointer for trucks

        for (int i = 0; i < length; i++) {
            if (carPtr != null) {
                array[i] = carPtr.data + " car";
                carPtr = carPtr.next;
            } else if (truckPtr != null) {
                array[i] = truckPtr.data + " truck";
                truckPtr = truckPtr.next;
            }
        }


        // Print array
        System.out.println("Array of vehicles:");
        for (Object obj : array) {
            System.out.println(obj);
        }
    }
}

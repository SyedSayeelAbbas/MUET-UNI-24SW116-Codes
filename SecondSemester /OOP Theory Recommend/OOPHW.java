class Vehicle {
    private int speed;

    Vehicle(int speed) {
        this.speed = speed;
    }

    public void display() {
        System.out.println("Car Speed :"+speed);
    }

    // The duplicate method returns an array of 10 Vehicle objects with the same speed
    public Vehicle[] duplicate() {
        Vehicle[] temp = new Vehicle[10];
        for (int i = 0; i < 10; i++) {
            temp[i] = new Vehicle(this.speed); // Creates a new object instead of referencing the same object
        }
        return temp;
    }
}

public class OOPHW {
    public static void main(String[] args) {
        Vehicle c1 = new Vehicle(12);
        Vehicle[] c2Array = c1.duplicate(); // Get an array of duplicated objects

        for (int i = 0; i < 10; i++) {
            c2Array[i].display(); // Print each duplicated object's speed
        }
    }
}

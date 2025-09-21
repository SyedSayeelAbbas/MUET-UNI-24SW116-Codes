class Vehicle {
    String type;
    String numberPlate;

    Vehicle(String type, String numberPlate) {
        this.type = type;
        this.numberPlate = numberPlate;
    }

    @Override
    public String toString() {
        return type + " (" + numberPlate + ")";
    }
}

class QueueNode {
    Vehicle data;
    QueueNode next;

    QueueNode(Vehicle data) {
        this.data = data;
        this.next = null;
    }
}

class FIFOQueue {
    QueueNode front, rear;

    FIFOQueue() {
        front = rear = null;
    }

    // Enqueue (insert at rear)
    void enqueue(Vehicle v) {
        QueueNode newNode = new QueueNode(v);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue (remove from front)
    Vehicle dequeue() {
        if (front == null) return null;
        Vehicle temp = front.data;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    // Display queue
    void display() {
        for (QueueNode p = front; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    // Print reverse (recursion)
    void reverseDisplay(QueueNode node) {
        if (node == null) return;
        reverseDisplay(node.next);
        System.out.println(node.data);
    }
}

public class TollQueue {
    public static void main(String[] args) {
        FIFOQueue v_Crossing_Toll = new FIFOQueue();

        // Insert 10 vehicles
        v_Crossing_Toll.enqueue(new Vehicle("Car", "ABC-101"));
        v_Crossing_Toll.enqueue(new Vehicle("Truck", "XYZ-202"));
        v_Crossing_Toll.enqueue(new Vehicle("SUV", "LMN-303"));
        v_Crossing_Toll.enqueue(new Vehicle("Van", "JKL-404"));
        v_Crossing_Toll.enqueue(new Vehicle("Bus", "PQR-505"));
        v_Crossing_Toll.enqueue(new Vehicle("Car", "AAA-606"));
        v_Crossing_Toll.enqueue(new Vehicle("Truck", "BBB-707"));
        v_Crossing_Toll.enqueue(new Vehicle("SUV", "CCC-808"));
        v_Crossing_Toll.enqueue(new Vehicle("Bus", "DDD-909"));
        v_Crossing_Toll.enqueue(new Vehicle("Car", "EEE-100"));

        // Convert to array for easy indexing
        Vehicle[] arr = new Vehicle[10];
        int i = 0;
        for (QueueNode p = v_Crossing_Toll.front; p != null; p = p.next) {
            arr[i++] = p.data;
        }

        // Print 1st and 7th
        System.out.println("1st Vehicle: " + arr[0]);
        System.out.println("7th Vehicle: " + arr[6]);

        // Print reverse
        System.out.println("\nVehicles in reverse order:");
        v_Crossing_Toll.reverseDisplay(v_Crossing_Toll.front);
    }
}

package TheoryExamPreparation;

import java.util.Random;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    // Count nodes
    public int count(Node start) {
        int c = 0;
        for (Node i = start; i != null; i = i.next) c++;
        return c;
    }

    // Easy shuffle
    public Node shuffle(Node start) {
        if (start == null) return null;

        // Step 1: Copy list into array
        int n = count(start);
        int[] arr = new int[n];
        Node p = start;
        for (int i = 0; i < n; i++) {
            arr[i] = p.data;
            p = p.next;
        }

        // Step 2: Fisher–Yates shuffle
        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        // Step 3: Copy back into list
        p = start;
        for (int i = 0; i < n; i++) {
            p.data = arr[i];
            p = p.next;
        }

        return start;
    }
}

public class ShufflingMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);

        start = start.shuffle(start);

        for (Node i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}

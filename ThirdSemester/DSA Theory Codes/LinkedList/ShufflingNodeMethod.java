//package TheoryExamPreparation;

import java.util.*;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    // Shuffle nodes by relinking them
    public Node shuffle(Node start) {
        if (start == null || start.next == null) return start;

        // Step 1: put all nodes into an ArrayList
        List<Node> nodes = new ArrayList<>();
        Node p = start;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }

        // Step 2: shuffle the ArrayList
        Collections.shuffle(nodes, new Random());

        // Step 3: rebuild the linked list
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        nodes.get(nodes.size() - 1).next = null;

        // New head
        return nodes.get(0);
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

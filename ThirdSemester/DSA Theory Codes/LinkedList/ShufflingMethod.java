package TheoryExamPreparation;

import java.util.Random;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public int count(Node start) {
        int c = 0;
        for (Node i = start; i != null; i = i.next) c++;
        return c;
    }

    public Node shuffle(Node start) {
        int mid = count(start) / 2;
        Node p = start;
        int[] part1 = new int[mid];
        int[] part2 = new int[count(start) - mid];

        for (int i = 0; i < mid; i++) {
            part1[i] = p.data;
            p = p.next;
        }
        for (int i = 0; i < part2.length; i++) {
            part2[i] = p.data;
            p = p.next;
        }

        Random rand = new Random();
        p = start;
        int i = 0, j = 0;
        while (p != null) {
            if (rand.nextBoolean() && i < part1.length) {
                p.data = part1[i++];
            } else if (j < part2.length) {
                p.data = part2[j++];
            } else if (i < part1.length) {
                p.data = part1[i++];
            }
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

        start = start.shuffle(start);

        for (Node i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}

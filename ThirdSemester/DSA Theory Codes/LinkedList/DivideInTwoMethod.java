package TheoryExamPreparation;

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

    public Node[] divideTwo(Node start) {
        int total = count(start);
        Node[] nodes = new Node[total];
        int idx = 0;
        for (Node i = start; i != null; i = i.next) {
            nodes[idx++] = i;
        }
        int mid = total / 2;
        if (mid > 0) nodes[mid - 1].next = null;

        Node[] result = new Node[2];
        result[0] = nodes[0];
        result[1] = nodes[mid];
        return result;
    }
}

public class DivideInTwoMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);

        Node obj = new Node(0); // dummy just to call method
        Node[] halves = obj.divideTwo(start);

        System.out.println("First Half:");
        for (Node i = halves[0]; i != null; i = i.next) {
            System.out.println(i.data);
        }

        System.out.println("Second Half:");
        for (Node i = halves[1]; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}

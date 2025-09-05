package TheoryExamPreparation;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public int count(Node start) {
        int c = 0;
        for (Node i = start; i != null; i = i.next) {
            c++;
        }
        return c;
    }

    // Divide into n parts
    public Node[] divideN(Node start, int n) {
        if (start == null || n <= 0) return new Node[0];

        int total = count(start);
        Node[] allNodes = new Node[total];
        int idx = 0;
        for (Node p = start; p != null; p = p.next) {
            allNodes[idx++] = p;
        }

        // Base size of each part
        int baseSize = total / n;
        int extra = total % n;  // distribute remainder

        Node[] result = new Node[n];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (pos < total) {
                result[i] = allNodes[pos];
                int size = baseSize + (i < extra ? 1 : 0); // some parts get +1
                pos += size;
                if (pos <= total - 1) {
                    allNodes[pos - 1].next = null; // break link
                }
            } else {
                result[i] = null; // if more parts than nodes
            }
        }
        return result;
    }
}

public class DivideNTimes {
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);
        start.next.next.next.next.next = new Node(6);
        start.next.next.next.next.next.next = new Node(7);

        Node obj = new Node(0); // dummy to call method
        Node[] parts = obj.divideN(start, 3); // divide into 3 parts

        for (int i = 0; i < parts.length; i++) {
            System.out.println("Part " + (i + 1) + ":");
            for (Node p = parts[i]; p != null; p = p.next) {
                System.out.print(p.data + " ");
            }
            System.out.println();
        }
    }
}

package TheoryExamPreparation;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node[] divideInNTimes(Node start, int n) {
        Node[] result = new Node[n];
        if (start == null || n <= 0) return result;

        // count total nodes
        int total = 0;
        for (Node p = start; p != null; p = p.next) {
            total++;
        }

        int baseSize = total / n;
        int extra = total % n; // distribute remainder

        Node curr = start;
        for (int i = 0; i < n && curr != null; i++) {
            result[i] = curr; // head of current part

            int size = baseSize + (i < extra ? 1 : 0); // first 'extra' parts get +1 node

            // move (size - 1) steps forward
            for (int j = 1; j < size && curr != null; j++) {
                curr = curr.next;
            }

            // cut the list
            if (curr != null) {
                Node nextNode = curr.next;
                curr.next = null;
                curr = nextNode;
            }
        }
        return result;
    }
}

public class Divider {
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);
        start.next.next.next = new Node(4);
        start.next.next.next.next = new Node(5);
        start.next.next.next.next.next = new Node(6);
        start.next.next.next.next.next.next = new Node(7);

        Node obj = new Node(0); // dummy to call method
        Node[] parts = obj.divideInNTimes(start, 3); // divide into 3 parts

        for (int i = 0; i < parts.length; i++) {
            System.out.print("Part " + (i + 1) + ": ");
            for (Node p = parts[i]; p != null; p = p.next) {
                System.out.print(p.data + " ");
            }
            System.out.println();
        }
    }
}

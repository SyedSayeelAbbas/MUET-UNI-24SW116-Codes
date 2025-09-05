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

    public Node reverse(Node start) {
        int n = count(start);
        int[] arr = new int[n];
        Node p = start;
        for (int i = 0; i < n; i++) {
            arr[i] = p.data;
            p = p.next;
        }
        p = start;
        for (int i = n - 1; i >= 0; i--) {
            p.data = arr[i];
            p = p.next;
        }
        return start;
    }
}

public class ReverseMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);

        start = start.reverse(start);

        for (Node i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}

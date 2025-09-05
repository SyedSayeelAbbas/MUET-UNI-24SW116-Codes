package TheoryExamPreparation;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node replace(Node start, int oldValue, int newValue) {
        for (Node i = start; i != null; i = i.next) {
            if (i.data == oldValue) {
                i.data = newValue;
            }
        }
        return start;
    }
}

public class ReplaceMethod {
    public static void main(String[] args) {
        Node start = new Node(10);
        start.next = new Node(20);
        start.next.next = new Node(30);

        start = start.replace(start, 20, 200);

        for (Node i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}

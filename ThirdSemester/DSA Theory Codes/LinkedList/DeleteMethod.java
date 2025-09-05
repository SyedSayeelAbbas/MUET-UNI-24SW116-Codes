package TheoryExamPreparation;
class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    // Delete method
    public Node delete(Node start, int value) {
        if (start == null) return null;
        if (start.data == value) return start.next;

        Node p = start;
        while (p.next != null) {
            if (p.next.data == value) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return start;
    }
}

public class DeleteMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        start.next = new Node(2);
        start.next.next = new Node(3);

        start = start.delete(start, 2);

        for (Node i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}



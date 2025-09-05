package TheoryExamPreparation;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    // Search method
    public boolean search(Node start, int value) {
        for (Node i = start; i != null; i = i.next) {
            if (i.data == value) return true;
        }
        return false;
    }
}

public class SearchMethod {
    public static void main(String[] args) {
        Node start = new Node(10);
        start.next = new Node(20);
        start.next.next = new Node(30);

        System.out.println("Search 20: " + start.search(start, 20));
        System.out.println("Search 40: " + start.search(start, 40));
    }
}

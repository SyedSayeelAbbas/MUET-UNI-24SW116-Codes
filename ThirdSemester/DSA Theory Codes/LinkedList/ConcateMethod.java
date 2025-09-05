package TheoryExamPreparation;

class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public Node concat(Node list1, Node list2) {
        if (list1 == null) return list2;
        Node p = list1;
        while (p.next != null) {
            p = p.next;
        }
        p.next = list2;
        return list1;
    }
}

public class ConcateMethod {
    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);

        Node list2 = new Node(100);
        list2.next = new Node(200);

        list1 = list1.concat(list1, list2);

        for (Node i = list1; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}

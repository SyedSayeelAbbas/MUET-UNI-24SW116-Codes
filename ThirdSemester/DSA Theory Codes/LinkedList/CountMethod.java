package TheoryExamPreparation;

class Node{
    Node next;
    int data;

    public Node (int data){
        this.data=data;
    }

    public int count(Node start){
        int count = 0;
        for(Node p = start;p!=null;p=p.next){
            count++;
        }
        return count;
    }
}

public class CountMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        Node p = start;
        p.next = new Node(2);
        p.next.next = new Node(3);

        System.out.println(start.count(start));
    }
}

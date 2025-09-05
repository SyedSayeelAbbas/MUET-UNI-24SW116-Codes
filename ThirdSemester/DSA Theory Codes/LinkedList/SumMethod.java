package TheoryExamPreparation;

class Node{
    Node next;
    int data;

    public Node (int data){
        this.data=data;
    }

    public int sum(Node start){
        int sum = 0;
        for(Node p = start;p!=null;p=p.next){
            sum+=p.data;
        }
        return sum;
    }
}

public class SumMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        Node p = start;
        p.next = new Node(2);
        p.next.next = new Node(3);

        System.out.println(start.sum(start));
    }
}

package TheoryExamPreparation;

class Node{
    Node next;
    int data;

    public Node (int data){
        this.data=data;
    }

    public void printLinkedList(Node start){
        int count = 0;
        for(Node p = start;p!=null;p=p.next){
            System.out.println("value of Node "+count+" is :"+p.data);
            count++;
        }
    }
}

public class PrintMethod {
    public static void main(String[] args) {
        Node start = new Node(1);
        Node p = start;
        p.next = new Node(2);
        p.next.next= new Node(3);

        start.printLinkedList(start);
    }
}

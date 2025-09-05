package TheoryExamPreparation;

class Node{
    Node next;
    int data;

    public Node (int data){
        this.data=data;
    }
    public Node (Node next,int data){
        this.data=data;
        this.next=next;
    }


    public Node insert(Node start , int value){
        if(start==null || start.data>value){
            start= new Node (start,value);
            return start;
        }
        Node p = start;
        while (p.next!=null){
            if(p.next.data>value){
                break;
            }
            p=p.next;
        }
        p.next = new Node (p.next,value);
        return start;
    }
}

public class InsertMethod {
    public static void main(String[] args) {
        Node start = new Node(1);

        start = start.insert(start, 2);
        start = start.insert(start, 0);
        start = start.insert(start, 5);

        for (Node i = start; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
}


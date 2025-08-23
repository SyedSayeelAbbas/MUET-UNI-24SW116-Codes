package SirMossen;

public class Node3 {
    int data;
    Node3 next;
    //Make a double argument Constructor
    public Node3(int data,Node3 next){
        this.data=data;
        this.next=next;
    }
    public Node3(int data){
        this.data=data;
    }
    //Make A Count Function in the LinedList
    public int count(Node3 start1){
        int count=0;
        for(Node3 print1=start1;print1!=null;print1=print1.next){
            count++;
        }
        return count;
    }
    //Make A Sum Function in the LinedList
    public int sum(Node3 start1){
        int sum=0;
        for(Node3 print1=start1;print1!=null;print1=print1.next){
            sum+= print1.data;
        }
        return sum;
    }
}

class Main2{
    public static void main(String[] args) {
        //how to apply a double argument Constructor and make a linked list
        Node3 start1 = new Node3(1,new Node3(3,new Node3(5,new Node3(7))));
        Node3 store1 = start1;
        //Printing using a While Loop
        while (store1!=null){
            System.out.println(store1.data);
            store1=store1.next;
        }
        //Linked List Count Function Usage
        System.out.println("Length of the Linked List:");
        System.out.println(start1.count(start1));
        //you can make it outside th linked list class as it can be more pro

        //Linked List Sum Function Usage
        System.out.println("Sum of the Linked List:");
        System.out.println(start1.sum(start1));
        //you can make it outside th linked list class as it can be more pro
    }
}

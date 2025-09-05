//package SirMossen;
//First Make a Class from Where you make a list or Chain
public class Node {
    //make a data storing variable
    int data;
    //make a class variable that will help make a linked list Structure
    Node2 next;
    //make a constructor
    public Node2(int data){
        this.data=data;
    }
    //make a double argument Constructor if needed
    public Node2(int data,Node2 next){
        this.data=data;
        this.next=next;
    }
}

class Main{
    public static void main(String[] args) {
        //Make the object and pass some data through constructor
        Node2 start = new Node2(1);
        //following method help in the chain making
        //next class variable has another class in it now we can say Node2 has another
        //Node2 inside it and this can go on and on
        start.next=new Node2(2);
        start.next.next=new Node2(3);
        //print a Linked List
        System.out.println("Method 1 Print");
        for(Node2 print = start;print!=null;print=print.next){
            System.out.println(print.data);
        }
        //USING ANOTHER METHOD FOR MAKING A LINKED LIST
        Node2 start2 = new Node2(1);
        Node2 store = start2;
        store.next=new Node2(2);
        store.next.next=new Node2(3);
        System.out.println("Method 2 Print");
        for(Node2 print2 = start2;print2!=null;print2=print2.next){
            System.out.println(print2.data);
        }
        //it is use so we are not changing the refrence of the linked list node class
        //MAKING NODE LIST BY A LOOP
        Node2 start3 = new Node2(1);
        Node2 store2 = start3;
        for(int i=0;i<5;i++){
            store2.next=new Node2(i+4*11);
            store2=store2.next;
        }
        System.out.println("Method 3 Print");
        for(Node2 print2 = start3;print2!=null;print2=print2.next){
            System.out.println(print2.data);
        }
    }
}

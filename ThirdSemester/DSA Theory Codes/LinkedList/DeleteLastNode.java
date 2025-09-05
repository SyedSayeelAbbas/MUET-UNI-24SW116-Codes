//package SirMossen;

class Node5{
    int data;
    Node5 next;
    public Node5(int data){
        this.data=data;
    }
    public Node5(int data,Node5 next){
        this.data=data;
        this.next=next;
    }
    public Node5 deleteLastNode(Node5 start){
        if(start==null||start.next==null) return null;
        Node5 temp = start;
        while(temp.next!=null){
            if(temp.next.next==null){
                temp.next=null;
                break;
            }
            temp=temp.next;
        }
        return start;
    }
}
public class DeleteLastNode {
    public static void main(String[] args) {
        Node5 list = new Node5(1);
        list.next = new Node5(2);
        list.next.next = new Node5(4);
        System.out.println("Before");
        for(Node5 start1=list;start1!=null;start1=start1.next ){
            System.out.println(start1.data);
        }
        System.out.println("After");
        list.deleteLastNode(list);
        for(Node5 start1=list;start1!=null;start1=start1.next ){
            System.out.println(start1.data);
        }
    }
}

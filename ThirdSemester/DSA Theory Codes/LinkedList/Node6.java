//package SirMossen;

class Node6{
    int data;
    Node6 next;

    public Node6(int data){
        this.data=data;
    }
    public Node6(int data,Node6 next){
        this.data=data;
        this.next=next;
    }
    public Node6 copyNode(Node6 copyFrom, Node6 copyIn) {
        if (copyFrom == null) return null;

        // copyIn becomes head of new list
        copyIn = new Node6(copyFrom.data);
        Node6 currentNew = copyIn;
        Node6 currentOld = copyFrom.next;

        while (currentOld != null) {
            currentNew.next = new Node6(currentOld.data);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }

        return copyIn;
    }
}

public class CopyNode {
    public static void main(String[] args) {
        Node6 list1 = new Node6(1);
        list1.next = new Node6(2);
        list1.next.next = new Node6(3);

        Node6 list2 = null; // this is passed as copyIn
        list2 = new Node6(0).copyNode(list1, list2); // method uses and returns updated copyIn

        System.out.println("List 1:");
        for (Node6 index = list1; index != null; index = index.next) {
            System.out.println(index.data);
        }

        System.out.println("List 2:");
        for (Node6 index = list2; index != null; index = index.next) {
            System.out.println(index.data);
        }
    }
}

//package SirMossen;

public class Node4 {
    int data;
    Node4 next;

    // Making a double argument constructor for Function used in the code
    public Node4(int data, Node4 next) {
        this.data = data;
        this.next = next;
    }

    //! Making a Single argument constructor if you want to
    public Node4(int data) {
        this.data = data;
    }

    // Making Insert Function for Linked List
    // example list(1,2,3,4,5) and value we want to insert is 2.5
    public Node4 insert(Node4 start1, int value) {
        // First we Check that weather the node is empty or is its value less than the
        // starting node as we have small to greater format in linked list
        // yes 2.5 is greater than start1.data value which is 1
        if (start1 == null || start1.data > value) {
            start1 = new Node4(value, start1);
            return start1;
        }

        // if the value is greater and first node is not empty then we move to next part
        Node4 store1 = start1;
        // we use store1.next as we already check store1 which was 1
        // now loop is start from 2
        while (store1.next != null && store1.next.data < value) {
            // and go to next node
            store1 = store1.next;
        }

        // loop was break where next node is greater
        // now before that we inserted value and gave it node store1.next position
        store1.next = new Node4(value, store1.next);
        // we return the start1
        return start1;
    }

    // Making Delete Function for Linked List
    public Node4 delete(Node4 start1, int value) {
        // Same reason as the above function
        if (start1 == null) return null;

        // If first node is the value
        if (start1.data == value) {
            return start1.next;
        }

        // start from the beginning
        for (Node4 print = start1; print.next != null; print = print.next) {
            // if value is found we replace it from the value or node in front of it
            if (print.next.data == value) {
                print.next = print.next.next;
                break;
            }
            // if next node is greater than value and list is sorted, break early
            if (print.next.data > value) {
                break;
            }
        }

        return start1;
    }

    // Making Search Function for Linked List
    public boolean search(Node4 start1, int value) {
        // Same reason as the above function
        if (start1 == null || start1.data > value) {
            return false;
        }

        for (Node4 print = start1; print != null; print = print.next) {
            if (print.data > value) {
                break;
            }
            // if value is found we return true
            else if (print.data == value) {
                return true;
            }
        }

        return false;
    }
    //This One is made By GPT so use gpt to learn more about it
    // ToString method to print the linked list nicely
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node4 current = this;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
}

class Main3 {
    public static void main(String[] args) {
        Node4 start1 = new Node4(1);
        start1 = start1.insert(start1, 2);
        start1 = start1.insert(start1, 3);
        start1 = start1.insert(start1, 4);
        start1 = start1.insert(start1, 5);

        System.out.println("Before Delete the loop after insert");
        System.out.println(start1); // uses toString

        start1 = start1.delete(start1, 3);

        System.out.println("After Delete the loop after insert");
        System.out.println(start1); // uses toString

        System.out.println("Search linked list method usage");
        System.out.println("Search 2: " + start1.search(start1, 2));   // true
        System.out.println("Search 14: " + start1.search(start1, 14)); // false
    }
}

interface Stack {
    void push(Object object);
}

class LinkedStack implements Stack {
    private Node top;
    private int size;

    private static class Node {
        Object object;
        Node next;

        public Node(Object object, Node next) {
            this.object = object;
            this.next = next;
        }
    }

    @Override
    public void push(Object object) {
        top = new Node(object, top);
        size++;
    }

    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.object + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class PushMain {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.printStack(); // C B A
    }
}

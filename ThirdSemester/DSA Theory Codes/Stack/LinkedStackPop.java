interface Stack {
    Object pop();
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
    public Object pop() {
        if (size == 0) throw new IllegalStateException("list is empty");
        Object temp = top.object;
        top = top.next;
        size--;
        return temp;
    }

    public void push(Object object) {
        top = new Node(object, top);
        size++;
    }
}

public class PopMain {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("X");
        stack.push("Y");
        stack.push("Z");
        System.out.println("Popped: " + stack.pop()); // Z
    }
}

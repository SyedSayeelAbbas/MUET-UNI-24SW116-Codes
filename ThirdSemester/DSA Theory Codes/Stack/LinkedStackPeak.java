interface Stack {
    Object peek();
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
    public Object peek() {
        if (size == 0) throw new IllegalStateException("list is empty");
        return top.object;
    }

    public void push(Object object) {
        top = new Node(object, top);
        size++;
    }
}

public class PeekMain {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(10);
        stack.push(20);
        System.out.println("Peek: " + stack.peek()); // 20
    }
}

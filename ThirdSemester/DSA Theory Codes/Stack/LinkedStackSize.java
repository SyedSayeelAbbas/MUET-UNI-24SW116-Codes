interface Stack {
    int size();
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

    public void push(Object object) {
        top = new Node(object, top);
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}

public class SizeMain {
    public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push("A");
        stack.push("B");
        System.out.println("Size: " + stack.size()); // 2
    }
}

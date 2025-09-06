interface Stack {
    LinkedStack toLinkedStack(StackArray arr);
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
    public LinkedStack toLinkedStack(StackArray arr) {
        if (arr.size() == 0) throw new IllegalStateException("Array Stack is empty");
        LinkedStack result = new LinkedStack();
        for (int i = 0; i < arr.size(); i++) {
            result.push(arr.pop());
        }
        return result;
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

// Simplified StackArray just for testing
class StackArray {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) {
        arr = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void push(Object object) {
        if (size == arr.length) resize();
        arr[size++] = object;
    }

    public Object pop() {
        if (size == 0) throw new IllegalStateException("Array is empty");
        Object temp = arr[--size];
        arr[size] = null;
        return temp;
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        arr = temp;
    }
}

public class ToLinkedStackMain {
    public static void main(String[] args) {
        StackArray arrayStack = new StackArray(2);
        arrayStack.push("One");
        arrayStack.push("Two");
        arrayStack.push("Three");

        LinkedStack linkedStack = new LinkedStack().toLinkedStack(arrayStack);
        linkedStack.printStack(); // Three Two One
    }
}

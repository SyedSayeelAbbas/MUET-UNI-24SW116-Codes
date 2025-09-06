interface Stack {
    StackArray toStackArray(LinkedStack linked);
}

class LinkedStack {
    Node top;
    int size;

    static class Node {
        Object object;
        Node next;
        Node(Object object, Node next) {
            this.object = object;
            this.next = next;
        }
    }

    public void push(Object object) {
        top = new Node(object, top);
        size++;
    }

    public int size() {
        return size;
    }
}

class LinkedStackToArray implements Stack {
    @Override
    public StackArray toStackArray(LinkedStack object) {
        if (object.size() == 0) throw new IllegalStateException("Linked Stack is empty");

        StackArray result = new StackArray(object.size());
        LinkedStack.Node current = object.top;
        LinkedStack temp = new LinkedStack();

        // Reverse order first
        while (current != null) {
            temp.push(current.object);
            current = current.next;
        }

        // Push back into result in correct order
        while (temp.size() > 0) {
            result.push(temp.top.object);
            temp.top = temp.top.next;
            temp.size--;
        }

        return result;
    }
}

class StackArray {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) {
        arr = new Object[capacity];
    }

    public void push(Object object) {
        if (size == arr.length) resize();
        arr[size++] = object;
    }

    public void printStack() {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        arr = temp;
    }
}

public class ToStackArrayMain {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");

        LinkedStackToArray converter = new LinkedStackToArray();
        StackArray arrayStack = converter.toStackArray(linkedStack);

        arrayStack.printStack(); // A B C
    }
}

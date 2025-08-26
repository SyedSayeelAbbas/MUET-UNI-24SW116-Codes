package SirMossen;

public class linkedStack implements Stack {
    private int size;
    private Node7 top;

    private static class Node7 {
        Object object;
        Node7 next;

        Node7(Object object, Node7 next) {
            this.object = object;
            this.next = next;
        }
    }

    public int size() { return size; }

    public void push(Object obj) {
        top = new Node7(obj, top);
        size++;
    }

    public Object peak() {
        if (size == 0) throw new IllegalStateException("empty");
        return top.object;
    }

    public Object pop() {
        if (size == 0) throw new IllegalStateException("empty");
        Object oldtop = top.object;
        top = top.next;
        size--;
        return oldtop;
    }

    // Convert this linked stack to an ArrayStack
    public static ArrayStack toArrayStack(linkedStack b) {
        if (b.size() == 0) throw new IllegalStateException("Empty");
        ArrayStack Temp = new ArrayStack(b.size());
        Node7 current = b.top;
        while (current != null) {
            Temp.push(current.object);
            current = current.next;
        }
        return Temp;
    }
    // Convert an ArrayStack to a new linkedStack
    public static linkedStack toLinkedStack(ArrayStack b) {
        if (b.getSize() == 0) throw new IllegalStateException("Empty");
        linkedStack Temp = new linkedStack();
        for (int i = 0; i <=b.getSize() - 1; i++) {
            Temp.push(b.a[i]);
        }
        return Temp;
    }

    public static void main(String[] args) {
        // Step 1: Create an ArrayStack and add elements
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push("Apple");
        arrayStack.push("Banana");
        arrayStack.push("Cherry");

        System.out.println("Original ArrayStack:");
        for (int i = 0; i < arrayStack.getSize(); i++) {
            System.out.println(arrayStack.a[i]);
        }

        // Step 2: Convert ArrayStack to linkedStack
        linkedStack lStack = toLinkedStack(arrayStack);

        System.out.println("\nConverted to linkedStack (top to bottom):");
        Node7 current = lStack.top;
        while (current != null) {
            System.out.println(current.object);
            current = current.next;
        }

        // Step 3: Convert back from linkedStack to ArrayStack
        ArrayStack backToArray = toArrayStack(lStack);

        System.out.println("\nConverted back to ArrayStack:");
        for (int i = 0; i < backToArray.getSize(); i++) {
            System.out.println(backToArray.a[i]);
        }
    }
}

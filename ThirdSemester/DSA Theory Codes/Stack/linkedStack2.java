//package SirMossen;

public class linkedStack implements Stack {
    private int size;
    private Node7 top;

    // Inner Node class
    private static class Node7 {
        Object object;
        Node7 next;

        Node7(Object object, Node7 next) {
            this.object = object;
            this.next = next;
        }
    }

    // --- Basic Stack Operations ---
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

    // --- Extra Methods from LinkedList version ---

    // Count nodes
    public int count() {
        return size;
    }

    // Sum of all integer values (works only if stack stores integers)
    public int sumOfStack() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        int sum = 0;
        Node7 temp = top;
        while (temp != null) {
            sum += (Integer) temp.object;
            temp = temp.next;
        }
        return sum;
    }

    // Search a value
    public boolean search(Object value) {
        Node7 temp = top;
        while (temp != null) {
            if (temp.object.equals(value)) return true;
            temp = temp.next;
        }
        return false;
    }

    // Delete last element (bottom of stack)
    public void deleteLast() {
        if (top == null) throw new IllegalStateException("Stack is empty");
        if (top.next == null) { // only one element
            top = null;
            size = 0;
            return;
        }
        Node7 temp = top;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    // Replace an old value with new value
    public void replace(Object oldValue, Object newValue) {
        Node7 temp = top;
        while (temp != null) {
            if (temp.object.equals(oldValue)) {
                temp.object = newValue;
            }
            temp = temp.next;
        }
    }

    // Reverse the stack (by data swap)
    public void reverse() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        Object[] arr = new Object[size];
        Node7 temp = top;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.object;
            temp = temp.next;
        }
        temp = top;
        for (int j = size - 1; j >= 0; j--) {
            temp.object = arr[j];
            temp = temp.next;
        }
    }

    // Copy the stack
    public linkedStack copy() {
        if (size == 0) return new linkedStack();
        Object[] arr = new Object[size];
        Node7 temp = top;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.object;
            temp = temp.next;
        }
        linkedStack copy = new linkedStack();
        for (int j = size - 1; j >= 0; j--) {
            copy.push(arr[j]); // push in reverse order
        }
        return copy;
    }

    // Concatenate with another stack (other stack elements added at bottom)
    public void concat(linkedStack other) {
        if (other.top == null) return;
        Object[] arr = new Object[other.size];
        Node7 temp = other.top;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.object;
            temp = temp.next;
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            this.push(arr[j]);
        }
    }

    // Divide stack into two halves
    public linkedStack[] divideTwo() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        int mid = size / 2;
        linkedStack first = new linkedStack();
        linkedStack second = new linkedStack();

        Object[] arr = new Object[size];
        Node7 temp = top;
        int i = 0;
        while (temp != null) {
            arr[i++] = temp.object;
            temp = temp.next;
        }
        // Fill first half
        for (int j = mid - 1; j >= 0; j--) {
            first.push(arr[j]);
        }
        // Fill second half
        for (int j = size - 1; j >= mid; j--) {
            second.push(arr[j]);
        }
        return new linkedStack[]{first, second};
    }

    // --- Conversions ---
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

    public static linkedStack toLinkedStack(ArrayStack b) {
        if (b.getSize() == 0) throw new IllegalStateException("Empty");
        linkedStack Temp = new linkedStack();
        for (int i = 0; i <= b.getSize() - 1; i++) {
            Temp.push(b.a[i]);
        }
        return Temp;
    }

    // --- Test main ---
    public static void main(String[] args) {
        linkedStack st = new linkedStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        System.out.println("Count: " + st.count());
        System.out.println("Sum: " + st.sumOfStack());
        System.out.println("Search 3: " + st.search(3));
        System.out.println("Search 10: " + st.search(10));

        st.replace(3, 30);
        System.out.println("After Replace (3->30), top element: " + st.peak());

        st.reverse();
        System.out.println("After Reverse, top element: " + st.peak());

        st.deleteLast();
        System.out.println("After deleteLast, count: " + st.count());

        linkedStack copy = st.copy();
        System.out.println("Copy stack count: " + copy.count());

        linkedStack second = new linkedStack();
        second.push(100);
        second.push(200);
        st.concat(second);
        System.out.println("After concat, count: " + st.count());

        linkedStack[] halves = st.divideTwo();
        System.out.println("First half count: " + halves[0].count());
        System.out.println("Second half count: " + halves[1].count());
    }
}

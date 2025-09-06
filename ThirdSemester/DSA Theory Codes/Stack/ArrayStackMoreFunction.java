//package SirMossen;

public interface Stack {
    Object peak();
    void push(Object obj);
    Object pop();
    int size();
}

class ArrayStack implements Stack {
    Object[] a;
    int size = 0;

    public ArrayStack() { }

    public ArrayStack(int cap) {
        this.a = new Object[cap];
    }

    // --- Core Methods ---
    public Object getElementAt(int index) {
        return a[index];
    }

    public int getSize() {
        return size;
    }

    public Object peak() {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        return a[size - 1];
    }

    public Object pop() {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        Object temp = a[--size];
        a[size] = null;
        return temp;
    }

    private void resize() {
        if (a == null || a.length == 0) {
            a = new Object[2];
        } else {
            Object[] temp = a;
            a = new Object[2 * temp.length];
            System.arraycopy(temp, 0, a, 0, size);
        }
    }

    public void push(Object obj) {
        if (a == null || size == a.length) resize();
        a[size++] = obj;
    }

    // --- Extra Methods (from LinkedList version) ---

    // Count
    public int count() {
        return size;
    }

    // Sum (works if elements are Integers)
    public int sumOfStack() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (Integer) a[i];
        }
        return sum;
    }

    // Search
    public boolean search(Object target) {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        for (int i = 0; i < size; i++) {
            if (a[i] == target || (a[i] != null && a[i].equals(target))) {
                return true;
            }
        }
        return false;
    }

    // Replace a value
    public void replace(Object oldValue, Object newValue) {
        for (int i = 0; i < size; i++) {
            if (a[i] != null && a[i].equals(oldValue)) {
                a[i] = newValue;
            }
        }
    }

    // Delete last element
    public void deleteLastElement() {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        a[size - 1] = null;
        size--;
    }

    // Delete second element from top
    public void deleteSecondElement() {
        if (size < 2) throw new IllegalStateException("Not enough elements.");
        a[size - 2] = a[size - 1];
        a[size - 1] = null;
        size--;
    }

    // Reverse stack
    public void reverse() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        for (int i = 0; i < size / 2; i++) {
            Object temp = a[i];
            a[i] = a[size - 1 - i];
            a[size - 1 - i] = temp;
        }
    }

    // Copy stack
    public ArrayStack copy() {
        ArrayStack copy = new ArrayStack(size);
        for (int i = 0; i < size; i++) {
            copy.push(a[i]);
        }
        return copy;
    }

    // Concatenate two stacks
    public void concat(ArrayStack other) {
        for (int i = 0; i < other.size; i++) {
            this.push(other.a[i]);
        }
    }

    // Divide into two halves
    public ArrayStack[] divideTwo() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        int mid = size / 2;
        ArrayStack first = new ArrayStack(mid);
        ArrayStack second = new ArrayStack(size - mid);

        for (int i = 0; i < mid; i++) {
            first.push(a[i]);
        }
        for (int i = mid; i < size; i++) {
            second.push(a[i]);
        }
        return new ArrayStack[]{first, second};
    }

    // Compare two stacks
    public boolean compareTwoStack(ArrayStack b) {
        if (this.size != b.size) return false;
        for (int i = 0; i < size; i++) {
            if (this.a[i] != b.a[i] && (this.a[i] == null || !this.a[i].equals(b.a[i]))) {
                return false;
            }
        }
        return true;
    }

    // Print stack
    public void PrintStack() {
        for (int j = 0; j < size; j++) {
            System.out.print(a[j] + " -> ");
        }
        System.out.println("NULL");
    }

    @Override
    public int size() {
        return size;
    }
}

// --- Testing ---
class Main4 {
    public static void main(String[] args) {
        ArrayStack st = new ArrayStack(5);
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
        System.out.println("After Replace 3 -> 30:");
        st.PrintStack();

        st.reverse();
        System.out.println("After Reverse:");
        st.PrintStack();

        st.deleteLastElement();
        System.out.println("After Delete Last:");
        st.PrintStack();

        ArrayStack copy = st.copy();
        System.out.println("Copied Stack:");
        copy.PrintStack();

        ArrayStack another = new ArrayStack();
        another.push(100);
        another.push(200);
        st.concat(another);
        System.out.println("After Concat:");
        st.PrintStack();

        ArrayStack[] halves = st.divideTwo();
        System.out.println("First Half:");
        halves[0].PrintStack();
        System.out.println("Second Half:");
        halves[1].PrintStack();
    }
}

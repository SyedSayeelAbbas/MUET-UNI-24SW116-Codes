interface Stack {
    void push(Object object);
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) {
        arr = new Object[capacity];
    }

    @Override
    public void push(Object object) {
        if (size == arr.length) resize();
        arr[size++] = object;
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void printStack() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class PushMain {
    public static void main(String[] args) {
        StackArray stack = new StackArray(2);
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.printStack(); // A B C
    }
}

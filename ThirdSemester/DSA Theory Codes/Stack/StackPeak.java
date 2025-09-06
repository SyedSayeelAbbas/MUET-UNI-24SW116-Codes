interface Stack {
    Object peek();
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) {
        arr = new Object[capacity];
    }

    @Override
    public Object peek() {
        if (size == 0) throw new IllegalStateException("Stack is Empty");
        return arr[size - 1];
    }

    public void push(Object object) {
        if (size == arr.length) resize();
        arr[size++] = object;
    }

    private void resize() {
        Object[] temp = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) temp[i] = arr[i];
        arr = temp;
    }
}

public class PeekMain {
    public static void main(String[] args) {
        StackArray stack = new StackArray(2);
        stack.push(10);
        stack.push(20);
        System.out.println("Peek: " + stack.peek()); // 20
    }
}

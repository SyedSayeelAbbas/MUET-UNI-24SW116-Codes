interface Stack {
    Object deleteLast();
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) { arr = new Object[capacity]; }

    @Override
    public Object deleteLast() {
        if (size == 0) throw new IllegalStateException("Stack is Empty");
        Object temp = arr[size - 1];
        arr[--size] = null;
        return temp;
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

public class DeleteLastMain {
    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
        stack.push("X");
        stack.push("Y");

        System.out.println("Deleted: " + stack.deleteLast()); // Y
    }
}

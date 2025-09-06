interface Stack {
    Object deleteSecondLast();
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) { arr = new Object[capacity]; }

    @Override
    public Object deleteSecondLast() {
        if (size < 2) throw new IllegalStateException("Not enough elements");
        Object temp = arr[size - 2];
        arr[size - 2] = arr[size - 1];
        arr[size - 1] = null;
        size--;
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

public class DeleteSecondLastMain {
    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Deleted: " + stack.deleteSecondLast()); // B
    }
}

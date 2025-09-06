interface Stack {
    int size();
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) { arr = new Object[capacity]; }

    @Override
    public int size() {
        return size;
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

public class SizeMain {
    public static void main(String[] args) {
        StackArray stack = new StackArray(2);
        stack.push("A");
        stack.push("B");
        System.out.println("Size: " + stack.size()); // 2
    }
}

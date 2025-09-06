interface Stack {
    boolean search(Object target);
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) { arr = new Object[capacity]; }

    @Override
    public boolean search(Object target) {
        if (size == 0) throw new IllegalStateException("Stack is Empty");
        for (int i = 0; i < size; i++) {
            if (arr[i] == target || (arr[i] != null && arr[i].equals(target))) {
                return true;
            }
        }
        return false;
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

public class SearchMain {
    public static void main(String[] args) {
        StackArray stack = new StackArray(2);
        stack.push("A");
        stack.push("B");
        System.out.println("Search A: " + stack.search("A")); // true
        System.out.println("Search X: " + stack.search("X")); // false
    }
}

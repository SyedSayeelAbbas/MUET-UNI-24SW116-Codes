interface Stack {
    boolean compare(StackArray other);
}

class StackArray implements Stack {
    private Object[] arr;
    private int size;

    public StackArray(int capacity) { arr = new Object[capacity]; }

    @Override
    public boolean compare(StackArray other) {
        if (this.size != other.size) return false;
        for (int i = 0; i < size; i++) {
            if (!(this.arr[i] == other.arr[i] ||
                 (arr[i] != null && arr[i].equals(other.arr[i])))) {
                return false;
            }
        }
        return true;
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

public class CompareMain {
    public static void main(String[] args) {
        StackArray s1 = new StackArray(2);
        StackArray s2 = new StackArray(2);

        s1.push("A"); s1.push("B");
        s2.push("A"); s2.push("B");

        System.out.println("Compare: " + s1.compare(s2)); // true
    }
}

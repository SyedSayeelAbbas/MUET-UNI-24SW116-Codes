package SirMossen;

public class ArrayQueue {
    private int size;
    private Object[] arr;

    // Constructor
    public ArrayQueue(int cap) {
        arr = new Object[cap];
        size = 0;
    }

    // --- Core Methods ---
    public Object add(Object obj) {
        if (size == arr.length) resize();
        arr[size++] = obj;
        return obj;
    }

    public Object first() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        return arr[0];
    }

    public Object remove() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        Object t = arr[0];
        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[--size] = null;
        return t;
    }

    private void resize() {
        if (arr == null || arr.length == 0) {
            arr = new Object[2];
        } else {
            Object[] newArr = new Object[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
    }

    public int size() {
        return size;
    }

    // --- Extra Methods ---

    // Count
    public int count() {
        return size;
    }

    // Sum (works for Integer values)
    public int sumOfQueue() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += (Integer) arr[i];
        }
        return sum;
    }

    // Search
    public boolean search(Object target) {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        for (int i = 0; i < size; i++) {
            if (arr[i] == target || (arr[i] != null && arr[i].equals(target))) {
                return true;
            }
        }
        return false;
    }

    // Replace value
    public void replace(Object oldVal, Object newVal) {
        for (int i = 0; i < size; i++) {
            if (arr[i] != null && arr[i].equals(oldVal)) {
                arr[i] = newVal;
            }
        }
    }

    // Delete last element
    public void deleteLastElement() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        arr[--size] = null;
    }

    // Delete second element
    public void deleteSecondElement() {
        if (size < 2) throw new IllegalStateException("Not enough elements.");
        for (int i = 2; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        arr[--size] = null;
    }

    // Reverse queue
    public void reverse() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        for (int i = 0; i < size / 2; i++) {
            Object temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    // Copy queue
    public ArrayQueue copy() {
        ArrayQueue copy = new ArrayQueue(size);
        for (int i = 0; i < size; i++) {
            copy.add(arr[i]);
        }
        return copy;
    }

    // Concatenate two queues
    public void concat(ArrayQueue other) {
        for (int i = 0; i < other.size; i++) {
            this.add(other.arr[i]);
        }
    }

    // Divide queue into two halves
    public ArrayQueue[] divideTwo() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        int mid = size / 2;
        ArrayQueue first = new ArrayQueue(mid);
        ArrayQueue second = new ArrayQueue(size - mid);

        for (int i = 0; i < mid; i++) first.add(arr[i]);
        for (int i = mid; i < size; i++) second.add(arr[i]);

        return new ArrayQueue[]{first, second};
    }

    // Compare two queues
    public boolean compareTwoQueue(ArrayQueue b) {
        if (this.size != b.size) return false;
        for (int i = 0; i < size; i++) {
            if (this.arr[i] != b.arr[i] && (this.arr[i] == null || !this.arr[i].equals(b.arr[i]))) {
                return false;
            }
        }
        return true;
    }

    // Print queue
    public void printQueue() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println("NULL");
    }

    // --- Testing ---
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        System.out.println("Queue:");
        q.printQueue();

        System.out.println("Count: " + q.count());
        System.out.println("Sum: " + q.sumOfQueue());
        System.out.println("Search 3: " + q.search(3));
        System.out.println("Search 10: " + q.search(10));

        q.replace(3, 30);
        System.out.println("After Replace 3->30:");
        q.printQueue();

        q.reverse();
        System.out.println("After Reverse:");
        q.printQueue();

        q.deleteLastElement();
        System.out.println("After Delete Last:");
        q.printQueue();

        q.deleteSecondElement();
        System.out.println("After Delete Second:");
        q.printQueue();

        ArrayQueue copy = q.copy();
        System.out.println("Copied Queue:");
        copy.printQueue();

        ArrayQueue another = new ArrayQueue(5);
        another.add(100);
        another.add(200);
        q.concat(another);
        System.out.println("After Concat:");
        q.printQueue();

        ArrayQueue[] halves = q.divideTwo();
        System.out.println("First Half:");
        halves[0].printQueue();
        System.out.println("Second Half:");
        halves[1].printQueue();

        System.out.println("Compare Original and Copy: " + q.compareTwoQueue(copy));
    }
}

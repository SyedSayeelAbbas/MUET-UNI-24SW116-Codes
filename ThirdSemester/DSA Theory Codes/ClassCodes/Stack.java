package SirMossen;

public interface Stack {
    Object peak();
    void push(Object obj);
    Object pop();
    int size();
}
class ArrayStack implements Stack {
     Object[] a;
     int size = 0;

     public ArrayStack(){

     }

    public Object getElementAt(int index) {
        return a[index];
    }

    public ArrayStack(int cap) {
        this.a = new Object[cap];
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Peak method
    public Object peak() {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        return a[size - 1];
    }

    // Pop method
    public Object pop() {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        Object temp = a[--size];
        a[size] = null;
        return temp;
    }

    // Resize (double capacity)
    private void resize() {
        Object[] temp = a;
        a = new Object[2 * temp.length];
        System.arraycopy(temp, 0, a, 0, size);
    }

    // Push method
    public void push(Object obj) {
        if (size == a.length) resize();
        a[size++] = obj;
    }

    // Search method
    public boolean search(Object target) {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        for (int i = 0; i < size; i++) {
            if (a[i] == target || (a[i] != null && a[i].equals(target))) {
                return true;
            }
        }
        return false;
    }

    // Delete second element from top
    public void deleteSecondElement() {
        if (size < 2) throw new IllegalStateException("Not enough elements to delete the second element.");
        a[size - 2] = a[size - 1];
        a[size - 1] = null;
        size--;
    }

    // Delete last element
    public void deleteLastElement() {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        a[size - 1] = null;
        size--;
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

    // Interface method implementation
    @Override
    public int size() {
        return size;
    }
}
class Main4 {
    public static void main(String[] args) {
        ArrayStack colddrinks = new ArrayStack(5);
        ArrayStack fruits = new ArrayStack(10);

        // Pushing elements
        colddrinks.push("NextCola");
        colddrinks.push("FizeUp");
        colddrinks.push("ColaNext");
        colddrinks.push("Dew");
        colddrinks.push(12);

        // Search
        System.out.println("Search Function:");
        System.out.println(colddrinks.search(12)); // true
        System.out.println("Stack Size: " + colddrinks.getSize());

        // Print before deletion
        colddrinks.PrintStack();

        // Delete second element from top
        colddrinks.deleteSecondElement();
        System.out.println("After Deleting Second Element:");
        System.out.println("Stack Size: " + colddrinks.getSize());
        colddrinks.PrintStack();

        // Compare with another stack
        fruits.push("NextCola");
        fruits.push("FizeUp");
        fruits.push("ColaNext");
        fruits.push("Dew");
        System.out.println("Compare colddrinks and fruits: " + colddrinks.compareTwoStack(fruits)); // false
    }
}
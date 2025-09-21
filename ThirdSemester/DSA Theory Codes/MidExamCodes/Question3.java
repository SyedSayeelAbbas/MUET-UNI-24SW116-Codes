class StackNode {
    Object data;
    StackNode next;

    StackNode(Object data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    StackNode top;

    // Push
    void push(Object data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop
    Object pop() {
        if (top == null) return null;
        Object val = top.data;
        top = top.next;
        return val;
    }

    // Display
    void display() {
        for (StackNode p = top; p != null; p = p.next) {
            System.out.println(p.data);
        }
    }

    // 1. Merge
    static Stack StackMerge(Stack s1, Stack s2) {
        Stack merged = new Stack();
        // Push all s2 elements first (so s1 ends up on top)
        StackNode p = s2.top;
        while (p != null) {
            merged.push(p.data);
            p = p.next;
        }
        p = s1.top;
        while (p != null) {
            merged.push(p.data);
            p = p.next;
        }
        return merged;
    }

    // 2. Halfer
    static Stack[] StackHalfer(Stack s1) {
        int count = 0;
        for (StackNode p = s1.top; p != null; p = p.next) count++;
        int mid = count / 2;

        Stack firstHalf = new Stack();
        Stack secondHalf = new Stack();

        int i = 0;
        for (StackNode p = s1.top; p != null; p = p.next) {
            if (i < mid) firstHalf.push(p.data);
            else secondHalf.push(p.data);
            i++;
        }
        return new Stack[]{firstHalf, secondHalf};
    }

    // 3. Bottom
    static Object StackBottom(Stack s1) {
        StackNode p = s1.top;
        while (p.next != null) p = p.next;
        return p.data;
    }

    // 4. Second from Top
    static Object Stack2ndFromTop(Stack s1) {
        if (s1.top == null || s1.top.next == null) return null;
        return s1.top.next.data;
    }
}

public class FruitStack {
    public static void main(String[] args) {
        Stack fruitCrate = new Stack();
        fruitCrate.push("Apple");
        fruitCrate.push("Banana");
        fruitCrate.push("Orange");
        fruitCrate.push("Mango");
        fruitCrate.push("Grapes");
        fruitCrate.push("Pineapple");

        System.out.println("Fruit Crate:");
        fruitCrate.display();

        System.out.println("\nBottom: " + Stack.StackBottom(fruitCrate));
        System.out.println("Second From Top: " + Stack.Stack2ndFromTop(fruitCrate));

        Stack[] halves = Stack.StackHalfer(fruitCrate);
        System.out.println("\nFirst Half:");
        halves[0].display();
        System.out.println("\nSecond Half:");
        halves[1].display();
    }
}

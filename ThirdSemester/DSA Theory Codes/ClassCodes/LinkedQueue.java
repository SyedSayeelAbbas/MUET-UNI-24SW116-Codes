package SirMossen;

import java.io.BufferedReader;

interface Queue {
    public int size();
    public Object first();
    public void add(Object obj);
    public Object remove();
}

public class LinkedQueue implements Queue {
    private int size;
    private Node8 head = new Node8(null); // sentinel node

    private static class Node8 {
        Object object;
        Node8 prev = this, next = this;

        Node8(Object obj) {
            this.object = obj;
        }

        Node8(Object obj, Node8 prev, Node8 next) {
            this.object = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public Object first() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        return head.next.object;
    }

    public void add(Object obj) {
        head.prev.next = new Node8(obj, head.prev, head);
        head.prev = head.prev.next;
        size++;
    }

    public Object remove() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        Object t = head.next.object;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return t;
    }

    public void reverse() {
        if (size <= 0) throw new IllegalStateException("Queue is empty");

        Node8 current = head;
        do {
            Node8 temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        } while (current != head);
    }

    public void print(){
        if (size <= 0) throw new IllegalStateException("Queue is empty");

        Node8 start = head.next;
        while (start!=head){
            System.out.println(start.object);
            start=start.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (Node8 i = head.next; i != head; i = i.next) {
            buff.append(i.object).append(" ");
        }
        return buff.toString().trim();
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node8 current = head.next; // start from first element
        for (int i = 0; i < size; i++) {
            array[i] = current.object;
            current = current.next;
        }
        return array;
    }

    public LinkedQueue cloneQueue() {
        if (size == 0) throw new IllegalStateException("Queue is empty");

        LinkedQueue copy = new LinkedQueue();
        for (Node8 i = head.next; i != head; i = i.next) {
            copy.add(i.object);
        }
        return copy;
    }

    public boolean compare(LinkedQueue h2) {
        if (size <= 0) throw new IllegalStateException("Queue 1 is empty");
        if (h2.size() <= 0) throw new IllegalStateException("Queue 2 is empty");
        if (size != h2.size()) return false;
        Node8 current1 = head.next;
        Node8 current2 = h2.head.next;
        while (current1 != head && current2 != h2.head) {
            if (!(current1.object == current2.object || current1.object.equals(current2.object))) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

    public void printOddElements() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        int position = 1;
        Node8 current = head.next; // start from first element
        do {
            if (position % 2 != 0) { // odd position
                System.out.print(current.object + " ");
            }
            position++;
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void printEvenElements() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        int position = 1;
        Node8 current = head.next;
        do {
            if (position % 2 == 0) { // even position
                System.out.print(current.object + " ");
            }
            position++;
            current = current.next;
        } while (current != head);
        System.out.println();
    }

}

class Main6 {
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        // Adding elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original queue: " + queue);

        // First element
        System.out.println("First element: " + queue.first());

        // Print odd position elements
        System.out.print("Odd position elements: ");
        queue.printOddElements();

        // Print even position elements
        System.out.print("Even position elements: ");
        queue.printEvenElements();

        // Convert to array
        Object[] arr = queue.toArray();
        System.out.print("Queue as array: ");
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();

        // Reverse the queue
        queue.reverse();
        System.out.println("After reverse: " + queue);

        // Clone the queue
        LinkedQueue cloned = queue.cloneQueue();
        System.out.println("Cloned queue: " + cloned);

        // Compare queues
        System.out.println("Compare original and clone: " + queue.compare(cloned));

        // Remove element
        System.out.println("Removed: " + queue.remove());
        System.out.println("Queue after removal: " + queue);

        // Compare after removal
        System.out.println("Compare after removal: " + queue.compare(cloned));
    }
}

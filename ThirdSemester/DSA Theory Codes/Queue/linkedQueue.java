package SirMossen;

import java.util.Random;

interface Queue {
    int size();
    Object first();
    void add(Object obj);
    Object remove();
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

    public int size() { return size; }

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

    public void print() {
        if (size <= 0) throw new IllegalStateException("Queue is empty");
        Node8 start = head.next;
        while (start != head) {
            System.out.print(start.object + " ");
            start = start.next;
        }
        System.out.println();
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
        Node8 current = head.next;
        for (int i = 0; i < size; i++) {
            array[i] = current.object;
            current = current.next;
        }
        return array;
    }

    public LinkedQueue cloneQueue() {
        LinkedQueue copy = new LinkedQueue();
        for (Node8 i = head.next; i != head; i = i.next) {
            copy.add(i.object);
        }
        return copy;
    }

    public boolean compare(LinkedQueue h2) {
        if (size != h2.size) return false;
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
        int pos = 1;
        Node8 cur = head.next;
        while (cur != head) {
            if (pos % 2 != 0) System.out.print(cur.object + " ");
            pos++;
            cur = cur.next;
        }
        System.out.println();
    }

    public void printEvenElements() {
        int pos = 1;
        Node8 cur = head.next;
        while (cur != head) {
            if (pos % 2 == 0) System.out.print(cur.object + " ");
            pos++;
            cur = cur.next;
        }
        System.out.println();
    }

    // --- Extra Queue Operations ---

    // Get last element
    public Object getLast() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        return head.prev.object;
    }

    // Clear queue
    public void clear() {
        head.next = head.prev = head;
        size = 0;
    }

    // Contains
    public boolean contains(Object obj) {
        for (Node8 cur = head.next; cur != head; cur = cur.next) {
            if (cur.object.equals(obj)) return true;
        }
        return false;
    }

    // Count occurrences
    public int countOccurrences(Object obj) {
        int count = 0;
        for (Node8 cur = head.next; cur != head; cur = cur.next) {
            if (cur.object.equals(obj)) count++;
        }
        return count;
    }

    // Remove last element
    public Object removeLast() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        Object val = head.prev.object;
        head.prev = head.prev.prev;
        head.prev.next = head;
        size--;
        return val;
    }

    // Remove at position
    public Object removeAt(int pos) {
        if (pos < 1 || pos > size) throw new IndexOutOfBoundsException("Invalid position");
        Node8 cur = head.next;
        for (int i = 1; i < pos; i++) cur = cur.next;
        Object val = cur.object;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
        return val;
    }

    // Shuffle queue
    public void shuffle() {
        if (size <= 1) return;
        Object[] arr = toArray();
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(arr.length);
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        clear();
        for (Object o : arr) add(o);
    }

    // Concatenate queues
    public void concat(LinkedQueue other) {
        for (Node8 cur = other.head.next; cur != other.head; cur = cur.next) {
            this.add(cur.object);
        }
    }
}

class Main6 {
    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.add("A"); q.add("B"); q.add("C"); q.add("D"); q.add("E");

        System.out.println("Original queue: " + q);

        System.out.println("First: " + q.first());
        System.out.println("Last: " + q.getLast());

        q.printOddElements();
        q.printEvenElements();

        System.out.println("Contains C? " + q.contains("C"));
        System.out.println("Occurrences of A: " + q.countOccurrences("A"));

        q.removeAt(3);
        System.out.println("After removeAt(3): " + q);

        q.removeLast();
        System.out.println("After removeLast: " + q);

        q.shuffle();
        System.out.println("After shuffle: " + q);

        LinkedQueue q2 = new LinkedQueue();
        q2.add("X"); q2.add("Y"); q2.add("Z");

        q.concat(q2);
        System.out.println("After concat with q2: " + q);
    }
}

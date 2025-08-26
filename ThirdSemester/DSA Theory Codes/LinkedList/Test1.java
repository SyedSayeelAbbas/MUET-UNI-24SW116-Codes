//package SirMossen;
import java.util.Random;
// Linked list node class with various integer-linked-list operations
public class Test1 {
    int data;       // Data stored in the node
    Test1 next;     // Reference (pointer) to the next node

    // Constructor: create a node with given data
    public Test1(int data) {
        this.data = data;
    }

    // Constructor: create a node with given data and next reference
    public Test1(int data, Test1 next) {
        this.data = data;
        this.next = next;
    }

    // Count number of nodes in the linked list
    public int count(Test1 start) {
        if (start == null) throw new IllegalStateException("Linked List is empty");
        int count = 0;
        // Traverse the list until null and increment counter
        for (Test1 i = start; i != null; i = i.next) {
            count++;
        }
        return count;
    }

    // Calculate the sum of all node values
    public int sumOfLinkedList(Test1 start) {
        if (start == null) throw new IllegalStateException("Linked List is empty");
        int sum = 0;
        // Traverse and add each node's data to sum
        for (Test1 i = start; i != null; i = i.next) {
            sum += i.data;
        }
        return sum;
    }

    // Insert a value while keeping ascending order
    public Test1 insert(int value, Test1 start) {
        // If the list is empty or the value should be inserted at start
        if (start == null || start.data > value) {
            return new Test1(value, start);
        }
        // Traverse to find the correct position
        Test1 temp = start;
        while (temp.next != null && temp.next.data < value) {
            temp = temp.next;
        }
        // Insert new node after 'temp'
        temp.next = new Test1(value, temp.next);
        return start;
    }

    // Delete a node by value
    public Test1 delete(int value, Test1 start) {
        if (start == null) return null;
        // If the first node is the one to delete
        if (start.data == value) return start.next;
        // Find the node before the one to delete
        Test1 temp = start;
        while (temp.next != null) {
            if (temp.next.data == value) {
                temp.next = temp.next.next; // Bypass the node
                break;
            }
            temp = temp.next;
        }
        return start;
    }

    // Search for a value in the list
    public boolean search(int value, Test1 start) {
        // Traverse and check each node's data
        for (Test1 i = start; i != null; i = i.next) {
            if (i.data == value) return true;
        }
        return false;
    }

    // Convert linked list into a string (e.g., "1 -> 2 -> 3")
    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        for (Test1 i = this; i != null; i = i.next) {
            buff.append(i.data);
            if (i.next != null) buff.append(" -> ");
        }
        return buff.toString();
    }

    // Delete the last node in the list
    public Test1 deleteLast(Test1 start) {
        if (start == null || start.next == null) return null; // Empty or single node list
        Test1 temp = start;
        // Stop at the node before last
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null; // Remove last node
        return start;
    }

    // Create a deep copy of the linked list
    public Test1 copy(Test1 from) {
        if (from == null) return null;
        // Create new head node
        Test1 newHead = new Test1(from.data);
        Test1 copyPointer = newHead;
        // Traverse and copy each node
        for (Test1 i = from.next; i != null; i = i.next) {
            copyPointer.next = new Test1(i.data);
            copyPointer = copyPointer.next;
        }
        return newHead;
    }

    // Concatenate two linked lists
    public Test1 concat(Test1 list1, Test1 list2) {
        if (list1 == null) return list2;
        // Move to last node of first list
        Test1 temp = list1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = list2; // Link second list
        return list1;
    }

    // Replace a value with another
    public Test1 replace(Test1 start, int oldValue, int newValue) {
        for (Test1 i = start; i != null; i = i.next) {
            if (i.data == oldValue) {
                i.data = newValue;
            }
        }
        return start;
    }

    // Reverse the linked list using an array (data swap)
    public Test1 reverse(Test1 start) {
        if (start == null) throw new IllegalStateException("Linked List is empty");
        int length = count(start); // Get total number of nodes
        int[] arr = new int[length]; // Store all node values
        Test1 temp = start;
        for (int i = 0; i < length; i++) {
            arr[i] = temp.data;
            temp = temp.next;
        }
        // Overwrite data in reverse order
        temp = start;
        for (int i = length - 1; i >= 0; i--) {
            temp.data = arr[i];
            temp = temp.next;
        }
        return start;
    }
    public Test1 shuffling(Test1 start) {
        if (start == null) throw new IllegalStateException("Linked List is empty");
        int mid = count(start) / 2;  // Your count method
        Test1 temporary = start;
        // Store first half and second half properly
        int[] part1 = new int[mid];
        int[] part2 = new int[count(start) - mid];
        // Fill part1
        for (int i = 0; i < mid && temporary != null; i++) {
            part1[i] = temporary.data;
            temporary = temporary.next;
        }
        // Fill part2
        for (int i = 0; i < part2.length && temporary != null; i++) {
            part2[i] = temporary.data;
            temporary = temporary.next;
        }
        // Shuffle by mixing parts back into the list
        java.util.Random rand = new java.util.Random();
        temporary = start;
        int i = 0, j = 0;
        while (temporary != null) {
            int randomNumber = rand.nextInt(10) + 1; // random logic
            if (randomNumber < 6 && i < part1.length) {
                temporary.data = part1[i++];
            } else if (j < part2.length) {
                temporary.data = part2[j++];
            } else if (i < part1.length) {
                temporary.data = part1[i++];
            }
            temporary = temporary.next;
        }
        return start;
    }
    // Divide the list into two halves and return them in an array
    public Test1[] divideTwo(Test1 start) {
        if (start == null) throw new IllegalStateException("Linked List is empty");
        int total = count(start);
        Test1[] allNodes = new Test1[total];
        // Store all nodes in an array
        int index = 0;
        for (Test1 p = start; p != null; p = p.next) {
            allNodes[index++] = p;
        }
        // Find midpoint
        int mid = total / 2;
        // Break the link to split the list into two
        if (mid > 0) allNodes[mid - 1].next = null;
        // Return the two heads
        Test1[] result = new Test1[2];
        result[0] = allNodes[0];    // first half head
        result[1] = allNodes[mid];  // second half head
        return result;
    }
}

// Main class to test all methods
class Main5 {
    public static void main(String[] args) {
        // Create initial linked list: 1 -> 3 -> 5
        Test1 list = new Test1(1);
        list.next = new Test1(3);
        list.next.next = new Test1(5);
        System.out.println("Original List: " + list);

        // Insert values while maintaining order
        list = list.insert(2, list); // Insert 2 between 1 and 3
        list = list.insert(4, list); // Insert 4 between 3 and 5
        System.out.println("After Insert: " + list);

        // Count number of nodes
        System.out.println("Count: " + list.count(list));
        // Sum of all node values
        System.out.println("Sum: " + list.sumOfLinkedList(list));

        // Search for values
        System.out.println("Search 3: " + list.search(3, list));
        System.out.println("Search 10: " + list.search(10, list));

        // Delete a specific node
        list = list.delete(3, list); // Remove node with value 3
        System.out.println("After Delete 3: " + list);

        // Replace a node's value
        list = list.replace(list, 4, 40); // Change 4 -> 40
        System.out.println("After Replace 4 with 40: " + list);

        // Reverse the list (using array method)
        list = list.reverse(list);
        System.out.println("After Reverse: " + list);

        // Delete the last node
        list = list.deleteLast(list);
        System.out.println("After Delete Last: " + list);

        // Copy the list
        Test1 copiedList = list.copy(list);
        System.out.println("Copied List: " + copiedList);

        // Concatenate with another list
        Test1 anotherList = new Test1(100);
        anotherList.next = new Test1(200);
        list = list.concat(list, anotherList);
        System.out.println("After Concat: " + list);

        // Divide the list into two halves
        Test1[] halves = list.divideTwo(list);
        System.out.println("First Half: " + halves[0]);
        System.out.println("Second Half: " + halves[1]);

    }
}

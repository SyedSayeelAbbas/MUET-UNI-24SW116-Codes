//package SirMossen;

public class Node {
    private int data;
    private Node next;

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Count Node List Method
    public static int count(Node start) {
        int count = 0;
        for (Node p = start; p != null; p = p.next) {
            count++;
        }
        return count;
    }

    // Sum List Node Method
    public static int sum(Node start) {
        int sum = 0;
        for (Node p = start; p != null; p = p.next) {
            sum += p.data;
        }
        return sum;
    }

    // Print List Node Method
    public static void print(Node start) {
        for (Node p = start; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
        System.out.println();
    }

    // Insert Node Method
    public static Node insert(Node start, int x) {
        if (start == null || x < start.data) {
            return new Node(x, start);
        }
        Node p = start;
        while (p.next != null && p.next.data < x) {
            p = p.next;
        }
        p.next = new Node(x, p.next);
        return start;
    }

    // Delete Node Method
    public static Node delete(Node start, int x) {
        if (start == null) return null;
        if (start.data == x) return start.next;

        Node p = start;
        while (p.next != null) {
            if (p.next.data == x) {
                p.next = p.next.next;
                break;
            }
            p = p.next;
        }
        return start;
    }

    // Search Node Method
    public static boolean search(Node start, int x) {
        for (Node p = start; p != null; p = p.next) {
            if (p.data == x) return true;
        }
        return false;
    }

    // To String Method
    public static String toString(Node start) {
        StringBuilder buff = new StringBuilder();
        for (Node p = start; p != null; p = p.next) {
            buff.append(p.data).append(" -> ");
        }
        buff.append("null");
        return buff.toString();
    }

    // Delete Last Node Method
    public static Node deleteLast(Node start) {
        if (start == null || start.next == null) {
            return null;
        }
        Node p = start;
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return start;
    }

    // Concatenate Two Lists Method
    public static Node concatenate(Node first, Node second) {
        if (first == null) return second;
        Node p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = second;
        return first;
    }

    // Copy Node Method
    public static Node copyList(Node start) {
        if (start == null) return null;
        Node newStart = new Node(start.data);
        Node pOld = start.next;
        Node pNew = newStart;
        while (pOld != null) {
            pNew.next = new Node(pOld.data);
            pNew = pNew.next;
            pOld = pOld.next;
        }
        return newStart;
    }

    // Replace an Element Method
    public static Node replace(Node start, int oldValue, int newValue) {
        for (Node p = start; p != null; p = p.next) {
            if (p.data == oldValue) {
                p.data = newValue;
                break;
            }
        }
        return start;
    }

    // Shuffle Lists Method (Alternate Merge of Two Lists using arrays)
    public static Node shuffleByArray(Node a, Node b) {
        int countA = count(a);
        int countB = count(b);
        Node[] arrA = new Node[countA];
        Node[] arrB = new Node[countB];
        int i = 0;
        for (Node p = a; p != null; p = p.next) {
            arrA[i++] = new Node(p.data);
        }
        int j = 0;
        for (Node p = b; p != null; p = p.next) {
            arrB[j++] = new Node(p.data);
        }
        Node[] result = new Node[countA + countB];
        int k = 0, idxA = 0, idxB = 0;
        while (idxA < countA && idxB < countB) {
            result[k++] = arrA[idxA++];
            result[k++] = arrB[idxB++];
        }
        while (idxA < countA) result[k++] = arrA[idxA++];
        while (idxB < countB) result[k++] = arrB[idxB++];
        for (int x = 0; x < result.length - 1; x++) {
            result[x].next = result[x + 1];
        }
        result[result.length - 1].next = null;
        return result[0];
    }

    // Reverse List Method using Array
    public static Node reverse(Node start) {
        int count = count(start);
        Node[] array = new Node[count];
        int i = 0;
        for (Node p = start; p != null; p = p.next) {
            array[i++] = p;
        }
        for (int j = count - 1; j > 0; j--) {
            array[j].next = array[j - 1];
        }
        array[0].next = null;
        return array[count - 1];
    }

    // Divide List in Two Parts and Return in Array
    public static Node[] divideTwo(Node start) {
        int count = count(start);
        Node[] allNodes = new Node[count];
        int i = 0;
        for (Node p = start; p != null; p = p.next) {
            allNodes[i++] = p;
        }
        int mid = count / 2;
        if (mid > 0) allNodes[mid - 1].next = null;
        Node[] result = new Node[2];
        result[0] = allNodes[0];
        result[1] = allNodes[mid];
        return result;
    }

    // Split List into Odd and Even Positions
    public static Node[] splitOddEven(Node start) {
        Node oddHead = null, evenHead = null;
        Node oddTail = null, evenTail = null;
        Node p = start;
        int index = 1;
        while (p != null) {
            if (index % 2 != 0) {
                if (oddHead == null) oddHead = oddTail = new Node(p.data);
                else {
                    oddTail.next = new Node(p.data);
                    oddTail = oddTail.next;
                }
            } else {
                if (evenHead == null) evenHead = evenTail = new Node(p.data);
                else {
                    evenTail.next = new Node(p.data);
                    evenTail = evenTail.next;
                }
            }
            p = p.next;
            index++;
        }
        return new Node[]{oddHead, evenHead};
    }

    // Split List by Value x
    public static Node[] splitByValue(Node start, int x) {
        Node lessHead = null, moreHead = null;
        Node lessTail = null, moreTail = null;
        for (Node p = start; p != null; p = p.next) {
            if (p.data < x) {
                if (lessHead == null) lessHead = lessTail = new Node(p.data);
                else {
                    lessTail.next = new Node(p.data);
                    lessTail = lessTail.next;
                }
            } else {
                if (moreHead == null) moreHead = moreTail = new Node(p.data);
                else {
                    moreTail.next = new Node(p.data);
                    moreTail = moreTail.next;
                }
            }
        }
        return new Node[]{lessHead, moreHead};
    }

    public static void main(String[] args) {
        Node list1 = new Node(10);
        list1.next = new Node(20);
        list1.next.next = new Node(30);
        list1.next.next.next = new Node(40);
        list1.next.next.next.next = new Node(50);
        list1.next.next.next.next.next = new Node(60);

        System.out.print("Original List: ");
        Node.print(list1);

        Node reversed = Node.reverse(list1);
        System.out.print("Reversed List: ");
        Node.print(reversed);

        list1 = reversed; // update to reversed head
        System.out.println("Count: " + Node.count(list1));
        System.out.println("Sum: " + Node.sum(list1));

        list1 = Node.deleteLast(list1);
        System.out.println("After Deleting Last Node: " + Node.toString(list1));

        list1 = Node.replace(list1, 10, 99);
        System.out.println("After Replacing 10 with 99: " + Node.toString(list1));

        Node list2 = new Node(15);
        list2 = Node.insert(list2, 25);
        System.out.println("List2: " + Node.toString(list2));

        Node combined = Node.concatenate(list1, list2);
        System.out.println("Concatenated List: " + Node.toString(combined));

        Node copied = Node.copyList(combined);
        System.out.println("Copied List: " + Node.toString(copied));

        Node[] halves = Node.divideTwo(copied);
        System.out.print("First Half: ");
        Node.print(halves[0]);
        System.out.print("Second Half: ");
        Node.print(halves[1]);

        Node[] splitOddEven = Node.splitOddEven(copied);
        System.out.print("Odd Position Nodes: ");
        Node.print(splitOddEven[0]);
        System.out.print("Even Position Nodes: ");
        Node.print(splitOddEven[1]);

        Node[] splitByValue = Node.splitByValue(copied, 30);
        System.out.print("Nodes < 30: ");
        Node.print(splitByValue[0]);
        System.out.print("Nodes >= 30: ");
        Node.print(splitByValue[1]);
    }
}

public class BinarySearchTree {
    private int key, height;
    private BinarySearchTree left, right;
    private static final BinarySearchTree NIL = new BinarySearchTree(); // ✅ fixed line

    // Constructor for regular nodes
    public BinarySearchTree(int key) {
        this.key = key;
        left = right = NIL;
        height = 0;
    }

    // Private constructor for NIL node
    private BinarySearchTree() {
        left = right = this;
        height = -1;
    }

    // Constructor for internal use
    private BinarySearchTree(int key, BinarySearchTree left, BinarySearchTree right) {
        this.key = key;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }

    // Add a new key to the tree
    public boolean add(int key) {
        int oldSize = size();
        grow(key);
        return oldSize < size();
    }

    // Recursive insertion (returns the updated subtree)
    public BinarySearchTree grow(int key) {
        if (this == NIL) return new BinarySearchTree(key);
        if (key == this.key) return this;
        if (key < this.key)
            left = left.grow(key);
        else
            right = right.grow(key);

        height = 1 + Math.max(left.height, right.height); // ✅ keep height updated
        return this;
    }

    // Count number of nodes
    public int size() {
        if (this == NIL) return 0;
        return 1 + left.size() + right.size();
    }

    // Inorder traversal as a string
    public String toString() {
        if (this == NIL) return "";
        return left + " " + key + " " + right;
    }
}
class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(8);

        System.out.println("BST (Inorder): " + bst);
        System.out.println("Size: " + bst.size());
    }
}

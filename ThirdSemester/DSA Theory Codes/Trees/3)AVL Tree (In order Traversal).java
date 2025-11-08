public class AVLTree {
    private int key, height;
    private AVLTree left, right;
    private static final AVLTree NIL = new AVLTree();

    // Constructor for regular nodes
    public AVLTree(int key) {
        this.key = key;
        left = right = NIL;
        height = 0;
    }

    // Private constructor for NIL node
    private AVLTree() {
        left = right = this;
        height = -1;
    }

    // Constructor for internal use
    private AVLTree(int key, AVLTree left, AVLTree right) {
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

    // Recursive insertion
    public AVLTree grow(int key) {
        if (this == NIL) return new AVLTree(key);
        if (key == this.key) return this;

        if (key < this.key)
            left = left.grow(key);
        else
            right = right.grow(key);

        rebalance();
        height = 1 + Math.max(left.height, right.height);
        return this;
    }

    // ---------- ROTATIONS (Simplified like your notebook) ----------

    private void rotateLeft() {
        AVLTree newLeft = new AVLTree(key, left, right.left);
        key = right.key;
        right = right.right;
        left = newLeft;
    }

    private void rotateRight() {
        AVLTree newRight = new AVLTree(key, left.right, right);
        key = left.key;
        left = left.left;
        right = newRight;
    }

    // ---------- REBALANCE (Simplified style) ----------

    private void rebalance() {
        if (right.height > left.height + 1) {
            if (right.left.height > right.right.height)
                right.rotateRight();
            rotateLeft();
        }
        else if (left.height > right.height + 1) {
            if (left.right.height > left.left.height)
                left.rotateLeft();
            rotateRight();
        }

        height = 1 + Math.max(left.height, right.height);
    }

    // ---------- EXTRA HELPERS ----------

    public int size() {
        if (this == NIL) return 0;
        return 1 + left.size() + right.size();
    }

    public String toString() {
        if (this == NIL) return "";
        return left + " " + key + " " + right;
    }
}

// ---------- MAIN ----------
class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree(10);
        tree.add(20);
        tree.add(5);
        tree.add(4);
        tree.add(15);
        tree.add(30);
        tree.add(25);

        System.out.println("AVL Tree (Inorder): " + tree);
        System.out.println("Size: " + tree.size());
    }
}

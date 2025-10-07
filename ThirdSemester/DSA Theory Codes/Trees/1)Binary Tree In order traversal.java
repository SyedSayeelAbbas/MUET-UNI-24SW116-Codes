package SirMossen;

public class BinaryTree {
    Object root;
    BinaryTree left, right;

    public BinaryTree(Object root) {
        this.root = root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    // Getters
    public Object getRoot() {
        return this.root;
    }

    public BinaryTree getLeft() {
        return this.left;
    }

    public BinaryTree getRight() {
        return this.right;
    }

    // Setters
    public void setRoot(Object root) {
        this.root = root;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    // In-order traversal (Left → Root → Right)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (left != null) {
            sb.append(left.toString());
            sb.append(" ");
        }
        sb.append(root);
        if (right != null) {
            sb.append(" ");
            sb.append(right.toString());
        }
        return sb.toString();
    }
}
class TestTree {
    public static void main(String[] args) {
        BinaryTree leftChild = new BinaryTree(2);
        BinaryTree rightChild = new BinaryTree(3);
        BinaryTree root = new BinaryTree(1, leftChild, rightChild);

        System.out.println(root); // Output: 2 1 3
    }
}

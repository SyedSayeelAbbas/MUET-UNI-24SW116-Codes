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

    // Is a Node A Leaf Function
    public boolean isLeaf(){
        if(left==null && right==null){
            return true;
        }
        return false;
    }

    // Tree size function
    public int size(){
        if (left==null && right==null){
            return 1;
        }
        else if(left==null) return 1+right.size();
        else if (right==null) return 1+ left.size();
        return 1+ left.size()+ right.size();
    }

    // Tree height Function
    public int height(){
        if (left==null && right==null){
            return 0;
        }
        else if(left==null) return 1+right.height();
        else if (right==null) return 1+ left.height();
        return 1+Math.max(left.height(), right.height());
    }

    // Search a Node Function
    public boolean search(Object value){
        if(value==root || root.equals(value)) return true;
        else if (left!=null){
            if (left.root==value || left.root.equals(value)){
                return true;
            }
            left.search(value);
        }
        else if (right!=null){
            if (right.root==value || right.root.equals(value)){
                return true;
            }
            right.search(value);
        }
        return false;
    }

    // Equals Function for tree
    public boolean equals(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        if (!tree1.root.equals(tree2.root)) return false;
        return equals(tree1.left, tree2.left) && equals(tree1.right, tree2.right);
    }

    // Is Full Function
    public boolean isFull() {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.isFull() && right.isFull();
        }
        return false;
    }
}
class TestTree {
    public static void main(String[] args) {
        BinaryTree n4 = new BinaryTree(4);
        BinaryTree n5 = new BinaryTree(5);
        BinaryTree n2 = new BinaryTree(2, n4, n5);
        BinaryTree n3 = new BinaryTree(3);
        BinaryTree root = new BinaryTree(1, n2, n3);

        System.out.println("Inorder Traversal: " + root);
        System.out.println("Is 4 a leaf? " + n4.isLeaf());
        System.out.println("Is 2 a leaf? " + n2.isLeaf());
        System.out.println("Tree size: " + root.size());
        System.out.println("Tree height: " + root.height());
        System.out.println("Search(5): " + root.search(5));
        System.out.println("Search(10): " + root.search(10));

        BinaryTree n4b = new BinaryTree(4);
        BinaryTree n5b = new BinaryTree(5);
        BinaryTree n2b = new BinaryTree(2, n4b, n5b);
        BinaryTree n3b = new BinaryTree(3);
        BinaryTree root2 = new BinaryTree(1, n2b, n3b);

        System.out.println("Equals(root, root2): " + root.equals(root, root2));
        System.out.println("Is full tree? " + root.isFull());
    }
}


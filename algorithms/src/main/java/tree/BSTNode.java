package tree;

public class BSTNode<T> {
    public T val;
    public BSTNode left;
    public BSTNode right;

    BSTNode(T val) {
        this.val = val;
        this.left = this.right = null;
    }
}

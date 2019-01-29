package tree;

public class BalancedBinaryTreeSolution<T> {

    public boolean isBalanced(BSTNode<T> root) {
        if (root == null) {
            return true;
        }
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);
        if (Math.abs(ld - rd) > 1) {
            return false;
        } else {
            return isBalanced(root.left) ? isBalanced(root.right) : false;
        }

    }

    public int maxDepth(BSTNode<T> t) {
        if (t == null) {
            return 0;
        }
        return Math.max(maxDepth(t.left), maxDepth(t.right)) + 1;
    }

    public int minDepth(BSTNode<T> t) {
        if (t == null) {
            return 0;
        }
        if (t.left == null && t.right == null) {
            return 1;
        }
        if (t.left == null) {
            return minDepth(t.right) + 1;
        }
        if (t.right == null) {
            return minDepth(t.left) + 1;
        }
        return Math.min(minDepth(t.left), minDepth(t.right)) + 1;
    }

}

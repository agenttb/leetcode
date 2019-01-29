package tree;

public class SameTreeSolution<T> {

    public boolean isSameTree(BSTNode<T> q, BSTNode<T> p) {
        if (q == null && p == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else {
            if (q.val == p.val) {
                return isSameTree(q.left, p.left) ? isSameTree(q.right, p.right) : false;
            } else {
                return false;
            }
        }
    }
}

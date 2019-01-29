package tree;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class PathSumSolution {

    public int pathSum(BinaryTreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);

    }

    private int pathSumFrom(BinaryTreeNode root,int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0)
                + pathSumFrom(root.left, sum - root.val)
                + pathSumFrom(root.right, sum - root.val);
    }

    public boolean hasPathSum(BinaryTreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}


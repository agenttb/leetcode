package tree;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = maxPathSum(root.left);
        int rightVal = maxPathSum(root.right);
        int maxValue = leftVal;
        if (maxValue > rightVal) {
            maxValue = rightVal;
        }
        return maxValue > (leftVal + rightVal + root.val) ? maxValue : leftVal + rightVal + root.val;
    }

}

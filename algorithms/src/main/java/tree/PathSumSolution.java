package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumSolution {
    public  int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int counter = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            counter += dfsPathSum(node, sum);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return counter;
    }
    private int dfsPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0)
                + dfsPathSum(root.left, sum - root.val) + dfsPathSum(root.right, sum - root.val);
    }

    private void dfsSearchTree(TreeNode root, int sum, LinkedList<Integer> output) {
        if (root == null) {
            return;
        }
        output.add(root.val);
        int res = sum - root.val;
        if (root.left == null && root.right == null && res == 0) {
            if (res != 0) {
                output.pop();
            }
            return;
        }
        dfsSearchTree(root.left, res, output);
        dfsSearchTree(root.right, res, output);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int res = sum - root.val;
        if (res == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, res) ? true : hasPathSum(root.right, res);
    }

    public List<List<Integer>> pathSumI(TreeNode root, int sum) {
        List<List<Integer>> output = new ArrayList<>();
        LinkedList<Integer> pathList = new LinkedList<>();
        dfsPathSumI(root, sum, pathList, output);
        return output;
    }

    private void dfsPathSumI(TreeNode root, int sum,
                                            LinkedList<Integer> pathList, List<List<Integer>> output) {
        if (root == null) {
            return;
        }
        pathList.add(root.val);
        int res = sum - root.val;
        if (root.left == null && root.right == null && res == 0) {
            output.add(new ArrayList<>(pathList));
        } else {
            dfsPathSumI(root.left, res, pathList, output);
            dfsPathSumI(root.right, res, pathList, output);
        }
        pathList.removeLast();

    }


}

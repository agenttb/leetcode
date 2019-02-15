package tree.BinaryTreeTraversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        postorder(root, output);
        return output;
    }

    private void postorder(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        postorder(root.left, output);
        postorder(root.right, output);
        output.add(root.val);
    }
}

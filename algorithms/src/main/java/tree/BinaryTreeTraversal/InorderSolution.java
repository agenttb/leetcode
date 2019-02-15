package tree.BinaryTreeTraversal;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        inorder(root, output);
        return output;
    }

    private void inorder(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }

        inorder(root.left, output);
        output.add(root.val);
        inorder(root.right, output);
    }

}

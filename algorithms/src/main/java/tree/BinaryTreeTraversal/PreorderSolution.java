package tree.BinaryTreeTraversal;

import tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderSolution {
    public List<Integer> preorderTraversal(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        preorderTraversal(root, output);
        return output;
    }

    private void preorderTraversal(BinaryTreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        output.add(root.val);
        preorderTraversal(root.left, output);
        preorderTraversal(root.right, output);
    }
}

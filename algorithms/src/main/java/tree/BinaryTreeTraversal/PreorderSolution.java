package tree.BinaryTreeTraversal;

import tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderSolution {
    public List<Integer> preorderTraversal(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        preorder(root, output);
        return output;
    }

    private void preorder(BinaryTreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        output.add(root.val);
        preorder(root.left, output);
        preorder(root.right, output);
    }
}

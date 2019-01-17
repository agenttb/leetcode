package tree.BinaryTreeTraversal;

import tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSolution {
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        inorderTraversal(root, output);
        return output;
    }

    private void inorderTraversal(BinaryTreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, output);
        output.add(root.val);
        inorderTraversal(root.right, output);
    }

}

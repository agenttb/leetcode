package tree.BinaryTreeTraversal;

import tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSolution {
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        inorder(root, output);
        return output;
    }

    private void inorder(BinaryTreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }

        inorder(root.left, output);
        output.add(root.val);
        inorder(root.right, output);
    }

}

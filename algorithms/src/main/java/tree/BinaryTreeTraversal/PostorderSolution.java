package tree.BinaryTreeTraversal;

import tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderSolution {
    public List<Integer> postorderTraversal(BinaryTreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        postorderTraversal(root, output);
        return output;
    }

    private void postorderTraversal(BinaryTreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, output);
        postorderTraversal(root.right, output);
        output.add(root.val);
    }
}

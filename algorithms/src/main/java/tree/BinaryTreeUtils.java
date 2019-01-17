package tree;

import java.util.List;

public class BinaryTreeUtils {
    public static BinaryTreeNode createInorderTree(List<Integer> input) {
        return doCreateInorder(input, 0);
    }

    private static BinaryTreeNode doCreateInorder(List<Integer> input, int index) {
        if (index >= input.size()) {
            return null;
        }
        if (input.get(index) == null) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(input.get(index));
        node.left = doCreateInorder(input,++index);
        node.right = doCreateInorder(input, ++index);
        return node;
    }
}

package tree;

import java.util.*;

public class BinaryTreeUtils {
    public static TreeNode createInorderTree(List<Integer> input) {
        return doCreateInorder(input, 0);
    }

    private static TreeNode doCreateInorder(List<Integer> input, int index) {
        if (index >= input.size()) {
            return null;
        }
        if (input.get(index) == null) {
            return null;
        }
        TreeNode node = new TreeNode(input.get(index));
        node.left = doCreateInorder(input, ++index);
        node.right = doCreateInorder(input, ++index);
        return node;
    }

    public static TreeNode levelCreateTree(List<Integer> input) {
        int index = 0;
        TreeNode root = new TreeNode(input.get(index++));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && index < input.size()) {
            TreeNode node = queue.poll();
            if (node != null) {
                Integer leftVal = input.get(index++);
                if (leftVal != null) {
                    TreeNode left = new TreeNode(leftVal);
                    node.left = left;
                    queue.add(left);
                }
                if (index >= input.size()) {
                    break;
                }
                Integer rightVal = input.get(index++);
                if (rightVal != null) {
                    TreeNode right = new TreeNode(rightVal);
                    node.right = right;
                    queue.add(right);
                }
            }
        }
        return root;
    }


    public static List<Integer> levelTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> output = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                output.add(node.val);
            }
        }
        return output;
    }

    public static TreeNode createBST(List<Integer> input) {
        TreeNode root = null;
        for (Integer i : input) {
            root = createBSTRec(root, i);
        }
        return root;
    }

    private static TreeNode  createBSTRec(TreeNode root, int x) {
        if (root == null) {
            return new TreeNode(x);
        }
        if (x < root.val) {
            root.left = createBSTRec(root.left, x);
        } else if ( x > root.val) {
            root.right = createBSTRec(root.right, x);
        }
        return root;
    }
}

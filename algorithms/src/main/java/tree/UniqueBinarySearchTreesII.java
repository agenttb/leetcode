package tree;


import util.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return null;
        }
        Map<String, TreeNode> map = new HashMap<>();
        int[] nums = new int[n];
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
            numsList.add(i+1);
        }
        int[] copyOf = Arrays.copyOf(nums, nums.length);

        List<List<Integer>> res = new ArrayList<>();
        res.add(numsList);
        while (true) {
            TreeNode treeNode = new TreeNode(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                bstInsert(treeNode, nums[i]);
            }
            List<Integer> levelTraversal = levelTraversal(treeNode);
            map.put(levelTraversal.toString(), treeNode);
            ArrayUtils.nextPermutation(nums);
            if (Arrays.equals(nums, copyOf)) {
                break;
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }

    public TreeNode bstInsert(TreeNode node, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (x < node.val) {
            node.left = bstInsert(node.left,x);
        } else if (x > node.val) {
            node.right = bstInsert(node.right, x);
        }
        return node;
    }

    public List<Integer> levelTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.left != null && node.right == null) {
                    queue.add(node.left);
                    queue.add(null);
                } if (node.right != null && node.left == null) {
                    queue.add(null);
                    queue.add(node.right);
                } else if (node.left != null && node.right != null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
                list.add(node.val);
            } else {
                list.add(null);
            }
        }
        if (list.getLast() == null)
            list.removeLast();
        return list;
    }

    public List<TreeNode> generateTreeRec(int n) {
        return generateTree(1, n);
    }


    private List<TreeNode> generateTree(int s, int e) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateTree(s, i - 1);
            List<TreeNode> rightSubtrees = generateTree(i + 1, e);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}

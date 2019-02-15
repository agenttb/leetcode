import org.junit.Assert;
import org.junit.Test;
import tree.TreeNode;
import tree.UniqueBinarySearchTreesII;

import java.util.List;

public class UniqueBinarySearchTreeIITest {
    private UniqueBinarySearchTreesII tree = new UniqueBinarySearchTreesII();
    @Test
    public void testCreateTree() {
        TreeNode node = new TreeNode(3);
        tree.bstInsert(node, 1);
        tree.bstInsert(node, 2);
        List<Integer> list = tree.levelTraversal(node);
        System.out.println(list);
    }

    @Test
    public void testGenerateTrees() {
        List<TreeNode> treeNodes = tree.generateTrees(0);
        Assert.assertNull(treeNodes);

        List<TreeNode> treeNodes1 = tree.generateTrees(1);
        treeNodes1.forEach(v -> System.out.println(tree.levelTraversal(v).toString()));

        List<TreeNode> treeNodes2 = tree.generateTrees(2);
        treeNodes2.forEach(v -> System.out.println(tree.levelTraversal(v).toString()));

        List<TreeNode> treeNodes3 = tree.generateTrees(3);
        treeNodes3.forEach(v -> System.out.println(tree.levelTraversal(v).toString()));
    }
}

import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTreeMaximumPathSum;
import tree.BinaryTreeUtils;
import tree.TreeNode;

import java.util.Arrays;

public class BinaryTreeMaximumPathSumTest {
    private BinaryTreeMaximumPathSum treeMaximumPathSum = new BinaryTreeMaximumPathSum();
    @Test
    public void testMaximumPathSumTest() {
        TreeNode root = BinaryTreeUtils.createBST(Arrays.asList(3,1,2,4,5,-10));
        int sum = treeMaximumPathSum.maxPathSum(root);
        Assert.assertEquals(15, sum);
    }
}
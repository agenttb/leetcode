import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTreeUtils;
import tree.TreeNode;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeUtilTest {

    @Test
    public void testBinaryTreeLevelCreate() {
        TreeNode treeNode = BinaryTreeUtils.levelCreateTree(Arrays.asList(new Integer[]{5, 4, 8, 11, null,
                13, 4, 7, 2, null, null, 5, 1}));
        List<Integer> integers = BinaryTreeUtils.levelTraversal(treeNode);
        Assert.assertArrayEquals(new Integer[] {5, 4, 8, 11, 13, 4, 7 ,2 , 5, 1},
                integers.toArray(new Integer[] {}));
    }
}

import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTreeUtils;
import tree.PathSumSolution;
import tree.TreeNode;

import java.util.Arrays;
import java.util.List;

public class PathSumSolutionTest{
    private PathSumSolution sumSolution = new PathSumSolution();
    @Test
    public void testPathSum() {
        TreeNode treeNode1 = BinaryTreeUtils.levelCreateTree(Arrays.asList(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}));
         int res1  = sumSolution.pathSum(treeNode1, 8);
        Assert.assertEquals(3, res1);

        TreeNode treeNode2 = BinaryTreeUtils.levelCreateTree(Arrays.asList(new Integer[] {1,-2,-3,1,3,-2,null,-1}));
        int res2 = sumSolution.pathSum(treeNode2, -1);
        Assert.assertEquals(4, res2);
    }

    @Test
    public void testPathSumI() {
        TreeNode treeNode = BinaryTreeUtils.levelCreateTree(Arrays.asList(new Integer[]{5, 4, 8,  11, null, 13, 4, 7,2 ,null, null, 5, 1}));
        var res = sumSolution.pathSumI(treeNode, 22);
        res.forEach(v -> System.out.println(v.toString()));
    }

}

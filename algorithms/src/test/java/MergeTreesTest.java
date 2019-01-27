import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTreeNode;
import tree.BinaryTreeTraversal.PreorderSolution;
import tree.BinaryTreeUtils;
import tree.MergeTreesSolution;

import java.util.Arrays;
import java.util.List;

public class MergeTreesTest {
    private MergeTreesSolution solution = new MergeTreesSolution();

    private PreorderSolution preorderSolution = new PreorderSolution();

    @Test
    public void testMergeTrees() {
        List<Integer> input1 = Arrays.asList(new Integer[]{1, 3, 2, 5});
        List<Integer> input2 = Arrays.asList(new Integer[]{2, 1, 3,null, 4, null, 7});
        BinaryTreeNode t1 = BinaryTreeUtils.createInorderTree(input1);
        BinaryTreeNode t2 = BinaryTreeUtils.createInorderTree(input2);

        BinaryTreeNode tree = solution.mergeTrees(t1, t2);
        List<Integer> output = preorderSolution.preorderTraversal(tree);
        System.out.println(output.toString());
        Assert.assertArrayEquals(new Integer[] {3, 4, 5, 5, 4, null, 7}, output.toArray(new Integer[output.size()]));
    }
}

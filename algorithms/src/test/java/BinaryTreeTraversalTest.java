import org.junit.Assert;
import org.junit.Test;
import tree.BinaryTreeTraversal.InorderSolution;
import tree.BinaryTreeNode;
import tree.BinaryTreeTraversal.PostorderSolution;
import tree.BinaryTreeTraversal.PreorderSolution;
import tree.BinaryTreeUtils;

import java.util.Arrays;
import java.util.List;

public class BinaryTreeTraversalTest {
    private InorderSolution solution = new InorderSolution();

    private PreorderSolution preorderSolution = new PreorderSolution();

    private PostorderSolution postorderSolution = new PostorderSolution();


    @Test
    public void testInorderTraversal() {
        List<Integer> input1 = Arrays.asList(new Integer[]{1, null, 2, 3});
        BinaryTreeNode root = BinaryTreeUtils.createInorderTree(input1);
        List<Integer> output1 = solution.inorderTraversal(root);
        Integer[] actuals = new Integer[3];
        Assert.assertArrayEquals(new Integer[] {1,3,2}, output1.toArray(actuals));
    }

    @Test
    public void testPreorderTraversal() {
        List<Integer> input1 = Arrays.asList(new Integer[]{1, null, 2, 3});
        BinaryTreeNode root = BinaryTreeUtils.createInorderTree(input1);
        List<Integer> output1 = preorderSolution.preorderTraversal(root);
        Integer[] actuals = new Integer[3];
        Assert.assertArrayEquals(new Integer[] {1,2,3}, output1.toArray(actuals));
    }

    @Test
    public void tsetPostorderTraversal() {
        List<Integer> input1 = Arrays.asList(new Integer[]{1, null, 2, 3});
        BinaryTreeNode root = BinaryTreeUtils.createInorderTree(input1);
        List<Integer> output1 = postorderSolution.postorderTraversal(root);
        Integer[] actuals = new Integer[3];
        Assert.assertArrayEquals(new Integer[] {3, 2, 1}, output1.toArray(actuals));
    }



}

import org.junit.Assert;
import org.junit.Test;
import tree.BST;
import tree.BalancedBinaryTreeSolution;

import java.util.Arrays;

public class BalanceBinaryTreeTest extends BSTBaseTest{
    private BalancedBinaryTreeSolution<Integer> solution = new BalancedBinaryTreeSolution<>();
    @Test
    public void testisBalancedTree() {
        BST<Integer> t1 = createBST(Arrays.asList(new Integer[]{4, 3, 2, 1}));
        Assert.assertFalse(solution.isBalanced(t1.getRoot()));
        BST<Integer> t2 = createBST(Arrays.asList(new Integer[]{2, 1, 3, 4}));
        Assert.assertTrue(solution.isBalanced(t2.getRoot()));
        BST<Integer> t3 = createBST(Arrays.asList(new Integer[]{2, 1, 3}));
        Assert.assertTrue(solution.isBalanced(t3.getRoot()));

        BST<Integer> t4 = createBST(Arrays.asList(2 , 1, 4, 3 ,5 , 6));
        Assert.assertFalse(solution.isBalanced(t4.getRoot()));
    }

    @Test
    public void testMinDepth() {
        BST<Integer> t1 =  createBST(Arrays.asList(new Integer[]{1, 2}));
        Assert.assertEquals(2, solution.minDepth(t1.getRoot()));

        BST<Integer> t2 =  createBST(Arrays.asList(new Integer[]{2, 1, 4, 3, 5, 6}));
        Assert.assertEquals(2, solution.minDepth(t2.getRoot()));
    }

    @Test
    public void testMaxDepth() {
        BST<Integer> t1 = createBST();
        Assert.assertEquals(4, solution.maxDepth(t1.getRoot()));

        BST<Integer> t2 = createBST(Arrays.asList(new Integer[]{1,2,3,4,5,6,7,8,9}));
        Assert.assertEquals(9, solution.maxDepth(t2.getRoot()));
    }
}

import org.junit.Assert;
import org.junit.Test;
import tree.BST;
import tree.SameTreeSolution;

public class SameTreeSolutionTest extends BSTBaseTest{
    private SameTreeSolution<Integer> solution = new SameTreeSolution<>();
    @Test
    public void testSameTree() {
        BST<Integer> t1 = createBST();
        BST<Integer> t2 = createBST();
        Assert.assertTrue(solution.isSameTree(t1.getRoot(), t2.getRoot()));
    }
}

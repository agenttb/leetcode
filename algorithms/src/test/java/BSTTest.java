import org.junit.Assert;
import org.junit.Test;
import tree.BST;

import java.util.Comparator;
import java.util.List;

public class BSTTest {

    final private int[] input = new int[] {11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
    final private Integer[] output = new Integer[] {11, 6, 4, 5, 8,10, 19, 17, 43, 31, 49};
    @Test
    public void testInsertIterative() {
        BST<Integer> bst = new BST<>(Comparator.comparingInt((Integer t) -> t));
        for (int i : input) {
            bst.insertTreeIterative(i);
        }
        List<Integer> list = bst.preOrderTraversal(bst.getRoot());

        Assert.assertArrayEquals(output, list.toArray(new Integer[list.size()]));
    }

    @Test
    public void testInsertRecursive() {
        BST<Integer> bst = new BST<Integer>(Comparator.comparingInt((Integer t) -> t)
        );
        for (int i : input) {
            bst.insertTree(i);
        }
        List<Integer> list = bst.preOrderTraversal(bst.getRoot());

        Assert.assertArrayEquals(output, list.toArray(new Integer[list.size()]));
    }

}

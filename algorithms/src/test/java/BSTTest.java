import org.junit.Assert;
import org.junit.Test;
import tree.BST;
import tree.BSTNode;

import java.util.Comparator;
import java.util.List;

public class BSTTest extends BSTBaseTest{


    @Test
    public void testInsertIterative() {
        BST<Integer> bst = createBST();
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

    @Test
    public void testTreeMinimum() {
        BST<Integer> bst = createBST();
        BSTNode<Integer> node = bst.treeMinimum(bst.getRoot().right);
        Assert.assertNotNull(node);
        Assert.assertEquals((Integer)17, node.val);
    }

    @Test
    public void testDeleteRecursive() {
        BST<Integer> bst1 = createBST();
        //case1: node with two child: Get inorder successor (smallest in the right subtree)
        bst1.delete(bst1.getRoot(), 11);
        List<Integer> list1 = bst1.preOrderTraversal(bst1.getRoot());
        Assert.assertArrayEquals(new Integer[]{17, 6, 4 ,5, 8, 10, 19, 43, 31, 49}, list1.toArray(new Integer[list1.size()]));

        //case2: node with only one child or no child
        BST<Integer> bst2 = createBST();
        bst2.delete(bst2.getRoot(), 8);
        List<Integer> list2 = bst2.preOrderTraversal(bst2.getRoot());
        Assert.assertArrayEquals(new Integer[]{11, 6, 4, 5 , 10, 19, 17, 43, 31, 49}, list2.toArray(new Integer[(list2.size())]));

    }

    @Test
    public void testLevelTraversalBST() {
        BST<Integer> bst = createBST();
        List<Integer> integers = bst.levelTraversal(bst.getRoot());
        System.out.println(integers.toString());

    }

    @Test
    public void testNOTOperation() {
        int cap = 50;
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
    }

}

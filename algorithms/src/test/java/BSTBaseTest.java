import tree.BST;

import java.util.Comparator;
import java.util.List;

public class BSTBaseTest {
    final protected int[] input = new int[] {11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31};
    final protected Integer[] output = new Integer[] {11, 6, 4, 5, 8,10, 19, 17, 43, 31, 49};



    protected BST<Integer> createBST() {
        BST<Integer> bst = new BST<>(Comparator.comparingInt((Integer t) -> t));
        for (int i : this.input) {
            bst.insertTreeIterative(i);
        }
        return bst;
    }

    public BST<Integer> createBST(List<Integer> input) {
        BST<Integer> bst = new BST<>(Comparator.comparingInt((Integer t) -> t));
        for (int i : input) {
            bst.insertTreeIterative(i);
        }
        return bst;
    }
}

package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BST<T>  {
    private BSTNode<T> root;
    private Comparator<T> comparator;

    public BST(Comparator cpr) {
        this.comparator = cpr;
    }

    public Boolean isEmpty() {
        return root == null ? true : false;
    }

    public BSTNode<T> getRoot() {
        return this.root;
    }

    public BSTNode<T> insertTree(T x) {
        root = doInsert(x, root);
        return root;
    }


    public void delete(BSTNode root, BSTNode node) {
        //case1: Left or right is null
        if (node.left == null) {
            node = node.right;
        } else if (node.right == null) {
            node = node.left;
        } else {
            // case2: node`s
            if (node.right.left == null) {
                BSTNode tmpNode = node.left;
                node = node.right;
                node.left  = tmpNode;
            } else {

            }
        }
    }

    public  BSTNode<T> treeSearch(BSTNode<T> t, T x) {
        if (t == null || x.equals(t.val)) {
            return t;
        }
        int cmp = comparator.compare(x, t.val);
        if (cmp < 0) {
            return treeSearch(t.left, x);
        } else {
            return treeSearch(t.right, x);
        }
    }

    public BSTNode<T> treeMinimum(BSTNode<T> t) {
        if (t == null) {
            return t;
        }
        if (t.left != null) {
            treeMinimum(t.left);
        }
        return t;
    }

    public BSTNode<T> treeMaximum(BSTNode<T> t) {
        if (t == null) {
            return t;
        }
        if (t.right != null) {
            treeMaximum(t.right);
        }
        return t;
    }

    public  BSTNode<T> insertTreeIterative(T x) {
        BSTNode<T> t = root;
        BSTNode<T> node = null;
        while (t != null) {
            int cmp = comparator.compare(x, t.val);
            node = t;
            if (cmp < 0) {
                t = t.left;
            } else if (cmp == 0) {
                return root;
            } else {
                t = t.right;
            }
        }

        if (node == null) {
            root = new BSTNode<>(x);
            return root;
        } else {
            int cmp = comparator.compare(x, node.val);
            if (cmp < 0) {
                node.left = new BSTNode<>(x);
            } else {
                node.right = new BSTNode<>(x);
            }
        }
        return root;
    }



    private BSTNode<T> doInsert(T x, BSTNode<T> node) {
        if (node == null) {
           node =  new BSTNode<>(x);
           return node;
        }
        int  cmp = comparator.compare(x, node.val);
         if (cmp < 0) {
            node.left =  doInsert(x, node.left);
        } else if (cmp > 0){
            node.right = doInsert(x, node.right);
        }
        return node;
    }

    public List<T> preOrderTraversal(BSTNode<T> root) {
        List<T> list = new ArrayList<T>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(BSTNode<T> root, List<T> output) {
        if (root == null) {
            return;
        }
        output.add(root.val);
        preOrder(root.left, output);
        preOrder(root.right, output);
    }
}

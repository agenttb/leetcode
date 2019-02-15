package tree;

import java.util.*;

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


    public void delete(BSTNode<T> root, T x) {
        this.root = doDeleteRec(root, x);
    }

    private BSTNode<T> doDeleteRec(BSTNode<T> root, T x) {
        if (root == null) {
            return null;
        }
        int cmp = comparator.compare(x, root.val);
        if (cmp < 0) {
            root.left = doDeleteRec(root.left, x);
        } else if (cmp > 0) {
            root.right = doDeleteRec(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BSTNode<T> minimum = treeMinimum(root.right);
                root.val = minimum.val;
                root.right = doDeleteRec(root.right, root.val);
            }
        }
        return root;
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
            return null;
        }
        if (t.left != null) {
            return treeMinimum(t.left);
        }
        return t;
    }

    public BSTNode<T> treeMaximum(BSTNode<T> t) {
        if (t == null) {
            return null;
        }
        if (t.right != null) {
            return treeMaximum(t.right);
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


    public List<T> levelTraversal(BSTNode<T> root) {
        if (root == null) {
            return null;
        }
        List<T> output = new ArrayList<>();
        Queue<BSTNode<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode<T> node = queue.poll();
            if (node != null) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                output.add(node.val);
            }
        }
        return output;
    }
}

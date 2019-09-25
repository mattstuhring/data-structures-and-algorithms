package tree;

import stacksandqueues.Node;
import stacksandqueues.Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tree<T> {
    public TreeNode<T> root;
    private int max = 0;
    private int leaf = 0;

    public Tree() {
        this.root = null;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public ArrayList<T> preOrder() {
        return preOrder(this.root, new ArrayList<>());
    }

    // Pre-order traversal
    // root node, left subtree, right subtree
    private ArrayList<T> preOrder(TreeNode<T> treeNode, ArrayList<T> arr) {
        if (treeNode != null) {
            // System.out.print(" " + node.value);
            arr.add(treeNode.value);

            preOrder(treeNode.left, arr);
            preOrder(treeNode.right, arr);
        }

        return arr;
    }

    public ArrayList<T> inOrder() {
        return inOrder(this.root, new ArrayList<>());
    }

    // The in-order traversal
    // left sub-tree, root node, right sub-tree
    private ArrayList<T> inOrder(TreeNode<T> treeNode, ArrayList<T> arr) {
        if (treeNode != null) {
            inOrder(treeNode.left, arr);

            // System.out.print(" " + node.value);
            arr.add(treeNode.value);

            inOrder(treeNode.right, arr);
        }

        return arr;
    }

    public ArrayList<T> postOrder() {
        return postOrder(this.root, new ArrayList<>());
    }

    // Post-order traversal
    // left subtree, right subtree, root node
    private ArrayList<T> postOrder(TreeNode<T> treeNode, ArrayList<T> arr) {
        if (treeNode != null) {
            postOrder(treeNode.left, arr);
            postOrder(treeNode.right, arr);

            // System.out.print(" " + node.value);
            arr.add(treeNode.value);
        }

        return arr;
    }

    public ArrayList<Integer> BinaryTreeBreadthFirst(Tree<Object> tree) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new Queue<>();

        if (tree.root == null) {
            return result;
        } else {
            queue.enqueue(tree.root);
        }

        while (queue.peek() != null) {
            TreeNode<Object> current = queue.peek();

            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }

            Integer value = (Integer) queue.dequeue().value;
            System.out.println(value);
            result.add(value);
        }

        return result;
    }

    public Integer findMaxValue(Tree<Object> tree) {
        if (tree.root == null) {
            return null;
        }

        findMaxValueRecursion(tree.root);

        return (Integer) max;
    }

    public void findMaxValueRecursion(TreeNode<Object> treeNode) {
        if (treeNode != null) {

            if ((int) treeNode.value > this.max) {
                this.max = (int) treeNode.value;
            }

            findMaxValueRecursion(treeNode.left);
            findMaxValueRecursion(treeNode.right);
        }
    }


    public int getLeafCount(Tree<Object> tree) {
        if (tree.root == null) {
            return 0;
        }

        getLeafCount(tree.root);

        return this.leaf;
    }

    private void getLeafCount(TreeNode treeNode) {
        if (treeNode != null) {

            if (treeNode.left == null && treeNode.right == null) {
                this.leaf++;
            }

            getLeafCount(treeNode.left);
            getLeafCount(treeNode.right);
        }
    }

    public List<Integer> findDups(Tree<T> tree) {
        if (tree.root == null) {
            return null;
        }

        List<Integer> dups = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        findDupsHelper(tree.root, map, dups);
        return dups;
    }

    private void findDupsHelper(TreeNode<T> treeNode, HashMap<Integer, Integer> map, List<Integer> dups) {

        if (map.containsKey(treeNode.value)) {
            dups.add((Integer) treeNode.value);
        } else {
            map.put((Integer) treeNode.value, (Integer) treeNode.value);
        }

        if (treeNode.left != null) {
            findDupsHelper(treeNode.left, map, dups);
        }

        if (treeNode.right != null) {
            findDupsHelper(treeNode.right, map, dups);
        }
    }

}

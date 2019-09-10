package tree;

import stacksandqueues.Queue;

import java.util.ArrayList;

public class Tree<T> {
    public Node<T> root;
    private int max = 0;
    private int leaf = 0;

    public Tree() {
        this.root = null;
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public ArrayList<T> preOrder() {
        return preOrder(this.root, new ArrayList<>());
    }

    // Pre-order traversal
    // root node, left subtree, right subtree
    private ArrayList<T> preOrder(Node<T> node, ArrayList<T> arr) {
        if (node != null) {
            // System.out.print(" " + node.value);
            arr.add(node.value);

            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }

        return arr;
    }

    public ArrayList<T> inOrder() {
        return inOrder(this.root, new ArrayList<>());
    }

    // The in-order traversal
    // left sub-tree, root node, right sub-tree
    private ArrayList<T> inOrder(Node<T> node, ArrayList<T> arr) {
        if (node != null) {
            inOrder(node.left, arr);

            // System.out.print(" " + node.value);
            arr.add(node.value);

            inOrder(node.right, arr);
        }

        return arr;
    }

    public ArrayList<T> postOrder() {
        return postOrder(this.root, new ArrayList<>());
    }

    // Post-order traversal
    // left subtree, right subtree, root node
    private ArrayList<T> postOrder(Node<T> node, ArrayList<T> arr) {
        if (node != null) {
            postOrder(node.left, arr);
            postOrder(node.right, arr);

            // System.out.print(" " + node.value);
            arr.add(node.value);
        }

        return arr;
    }

    public ArrayList<Integer> BinaryTreeBreadthFirst(Tree<Object> tree) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> queue = new Queue<>();

        if (tree.root == null) {
            return result;
        } else {
            queue.enqueue(tree.root);
        }

        while (queue.peek() != null) {

            if (queue.peek().left != null) {
                queue.enqueue(queue.peek().left);
            }

            if (queue.peek().right != null) {
                queue.enqueue(queue.peek().right);
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

    public void findMaxValueRecursion(Node<Object> node) {
        if (node != null) {

            if ((int)node.value > this.max) {
                this.max = (int)node.value;
            }

            findMaxValueRecursion(node.left);
            findMaxValueRecursion(node.right);
        }
    }


    public int getLeafCount(Tree<Object> tree) {
        if (tree.root == null) {
            return 0;
        }

        getLeafCount(tree.root);

        return this.leaf;
    }

    private void getLeafCount(Node node) {
        if (node != null) {

            if (node.left == null && node.right == null) {
                this.leaf++;
            }

            getLeafCount(node.left);
            getLeafCount(node.right);
        }
    }
}

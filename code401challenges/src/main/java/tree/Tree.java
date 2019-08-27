package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tree<T> {
    public Node<T> root;

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
}

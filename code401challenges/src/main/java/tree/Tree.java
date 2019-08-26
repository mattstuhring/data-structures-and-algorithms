package tree;

import java.util.ArrayList;

public class Tree<T> {
    Node<T> root;

    public Tree() {
        this.root = null;
    }

    // Pre-order traversal
    // root node, left subtree, right subtree
    public ArrayList<T> preOrder(Node<T> node, ArrayList<T> arr) {
        if (node != null) {
            // System.out.print(" " + node.value);
            arr.add(node.value);

            preOrder(node.left, arr);
            preOrder(node.right, arr);
        }

        return arr;
    }

    // The in-order traversal
    // left sub-tree, root node, right sub-tree
    public ArrayList<T> inOrder(Node<T> node, ArrayList<T> arr) {
        if (node != null) {
            inOrder(node.left, arr);

            // System.out.print(" " + node.value);
            arr.add(node.value);

            inOrder(node.right, arr);
        }

        return arr;
    }

    // Post-order traversal
    // left subtree, right subtree, root node
    public ArrayList<T> postOrder(Node<T> node, ArrayList<T> arr) {
        if (node != null) {
            postOrder(node.left, arr);
            postOrder(node.right, arr);

            // System.out.print(" " + node.value);
            arr.add(node.value);
        }

        return arr;
    }
}

package tree;

public class BinarySearchTree extends Tree<Integer> {

    public BinarySearchTree() {
        super();
    }

    // https://www.youtube.com/watch?v=OgJL8eh87PI
    // Define a method named add that accepts a value, and adds a new node with that value in the correct location in the binary search tree.
    public void add(int value) {
        Node<Integer> nodeToAdd = new Node<>(value);

        if (this.root == null) {
            this.root = nodeToAdd;
        }

        traverseAndAddNode(this.root, nodeToAdd);
    }

    private void traverseAndAddNode(Node<Integer> node, Node<Integer> nodeToAdd) {
        if (nodeToAdd.value < node.value) {

            if (node.left == null) {
                node.left = nodeToAdd;
            } else {
                traverseAndAddNode(node.left, nodeToAdd);
            }

        } else if (nodeToAdd.value > node.value) {

            if (node.right == null) {
                node.right = nodeToAdd;
            } else {
                traverseAndAddNode(node.right, nodeToAdd);
            }

        }
    }

    // https://www.baeldung.com/java-binary-tree
    // Define a method named contains that accepts a value, and returns a boolean indicating whether or not the value is in the tree at least once.
    public boolean contains(int value) {
        return containsNodeRecursive(this.root, value);
    }

    private boolean containsNodeRecursive(Node<Integer> current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

        if (value < current.value) {
            return containsNodeRecursive(current.left, value);
        } else {
            return containsNodeRecursive(current.right, value);
        }
    }
}

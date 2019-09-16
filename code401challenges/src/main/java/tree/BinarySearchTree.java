package tree;

public class BinarySearchTree extends Tree<Integer> {

    public BinarySearchTree() {
        super();
    }

    // https://www.youtube.com/watch?v=OgJL8eh87PI
    // Define a method named add that accepts a value, and adds a new node with that value in the correct location in the binary search tree.
    public void add(int value) {
        TreeNode<Integer> treeNodeToAdd = new TreeNode<>(value);

        if (this.root == null) {
            this.root = treeNodeToAdd;
        }

        traverseAndAddNode(this.root, treeNodeToAdd);
    }

    private void traverseAndAddNode(TreeNode<Integer> treeNode, TreeNode<Integer> treeNodeToAdd) {
        if (treeNodeToAdd.value < treeNode.value) {

            if (treeNode.left == null) {
                treeNode.left = treeNodeToAdd;
            } else {
                traverseAndAddNode(treeNode.left, treeNodeToAdd);
            }

        } else if (treeNodeToAdd.value > treeNode.value) {

            if (treeNode.right == null) {
                treeNode.right = treeNodeToAdd;
            } else {
                traverseAndAddNode(treeNode.right, treeNodeToAdd);
            }

        }
    }

    // https://www.baeldung.com/java-binary-tree
    // Define a method named contains that accepts a value, and returns a boolean indicating whether or not the value is in the tree at least once.
    public boolean contains(int value) {
        return containsNodeRecursive(this.root, value);
    }

    private boolean containsNodeRecursive(TreeNode<Integer> current, int value) {
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

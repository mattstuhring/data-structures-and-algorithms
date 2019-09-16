package utilities;


import tree.TreeNode;
import tree.Tree;

public class FizzBuzzTree {

    public FizzBuzzTree() {}

    public Tree<Object> fizzBuzzTree(Tree<Object> tree) {
        fizzBuzzTreeRecursion(tree.root);

        return tree;
    }

    private void fizzBuzzTreeRecursion(TreeNode<Object> treeNode) {
        if (treeNode != null) {
            if ((int) treeNode.value % 3 == 0 && (int) treeNode.value % 5 == 0) {
                treeNode.value = "FizzBuzz";
            } else if ((int) treeNode.value % 3 == 0) {
                treeNode.value = "Fizz";
            } else if ((int) treeNode.value % 5 == 0) {
                treeNode.value = "Buzz";
            }

            fizzBuzzTreeRecursion(treeNode.left);
            fizzBuzzTreeRecursion(treeNode.right);
        }
    }
}

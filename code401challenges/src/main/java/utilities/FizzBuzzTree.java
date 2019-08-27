package utilities;


import tree.Node;
import tree.Tree;

public class FizzBuzzTree {

    public FizzBuzzTree() {}

    public Tree<Object> fizzBuzzTree(Tree<Object> tree) {
        fizzBuzzTreeRecursion(tree.root);

        return tree;
    }

    private void fizzBuzzTreeRecursion(Node<Object> node) {
        if (node != null) {
            if ((int)node.value % 3 == 0 && (int)node.value % 5 == 0) {
                node.value = "FizzBuzz";
            } else if ((int)node.value % 3 == 0) {
                node.value = "Fizz";
            } else if ((int)node.value % 5 == 0) {
                node.value = "Buzz";
            }

            fizzBuzzTreeRecursion(node.left);
            fizzBuzzTreeRecursion(node.right);
        }
    }
}

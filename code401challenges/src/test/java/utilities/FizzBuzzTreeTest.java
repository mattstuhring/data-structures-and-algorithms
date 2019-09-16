package utilities;

import org.junit.Test;
import tree.TreeNode;
import tree.Tree;

import static org.junit.Assert.*;

public class FizzBuzzTreeTest {

    @Test
    public void testFizzBuzzTree_test1() {
        //      10
        //     /  \
        //    5   13
        //   / \  / \
        //  3  7 11 15

        Tree<Object> tree = new Tree<>();
        tree.root = new TreeNode<>(10);
        tree.root.left = new TreeNode<>(5);
        tree.root.right = new TreeNode<>(13);
        tree.root.left.left = new TreeNode<>(3);
        tree.root.left.right = new TreeNode<>(7);
        tree.root.right.right = new TreeNode<>(15);
        tree.root.right.left = new TreeNode<>(11);

        FizzBuzzTree fbt = new FizzBuzzTree();

        assertEquals("[Fizz, Buzz, 7, Buzz, 11, 13, FizzBuzz]", fbt.fizzBuzzTree(tree).inOrder().toString());
    }

    @Test
    public void testFizzBuzzTree_test2() {
        //      15
        //     /  \
        //    4   20
        //   / \  / \
        //  1  7 12 26

        Tree<Object> tree = new Tree<>();
        tree.root = new TreeNode<>(15);
        tree.root.left = new TreeNode<>(4);
        tree.root.right = new TreeNode<>(20);
        tree.root.left.left = new TreeNode<>(1);
        tree.root.left.right = new TreeNode<>(5);
        tree.root.right.right = new TreeNode<>(26);
        tree.root.right.left = new TreeNode<>(12);

        FizzBuzzTree fbt = new FizzBuzzTree();

        assertEquals("[1, 4, Buzz, FizzBuzz, Fizz, Buzz, 26]", fbt.fizzBuzzTree(tree).inOrder().toString());
    }
}
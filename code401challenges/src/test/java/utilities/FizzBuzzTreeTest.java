package utilities;

import org.junit.Test;
import tree.Node;
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
        tree.root = new Node<>(10);
        tree.root.left = new Node<>(5);
        tree.root.right = new Node<>(13);
        tree.root.left.left = new Node<>(3);
        tree.root.left.right = new Node<>(7);
        tree.root.right.right = new Node<>(15);
        tree.root.right.left = new Node<>(11);

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
        tree.root = new Node<>(15);
        tree.root.left = new Node<>(4);
        tree.root.right = new Node<>(20);
        tree.root.left.left = new Node<>(1);
        tree.root.left.right = new Node<>(5);
        tree.root.right.right = new Node<>(26);
        tree.root.right.left = new Node<>(12);

        FizzBuzzTree fbt = new FizzBuzzTree();

        assertEquals("[1, 4, Buzz, FizzBuzz, Fizz, Buzz, 26]", fbt.fizzBuzzTree(tree).inOrder().toString());
    }
}
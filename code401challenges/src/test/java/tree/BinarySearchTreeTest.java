package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testInstantiateEmptyTree() {
        BinarySearchTree tree = new BinarySearchTree();

        assertNull(tree.root);
    }

    @Test
    public void testInstantiateWithSingleRootNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(7);

        assertNotNull(tree.root);
    }

    @Test
    public void testAddLeftAndRightChildToSingleRootNode() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(7);
        tree.add(4);
        tree.add(9);

        assertEquals(7, (int)tree.root.value);
        assertEquals(4, (int)tree.root.left.value);
        assertEquals(9, (int)tree.root.right.value);
    }

    @Test
    public void testInOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(25);
        tree.add(20);
        tree.add(27);
        tree.add(15);
        tree.add(22);
        tree.add(26);
        tree.add(30);
        tree.add(29);
        tree.add(32);

        assertEquals("[15, 20, 22, 25, 26, 27, 29, 30, 32]", tree.inOrder().toString());
    }

    @Test
    public void testPreOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(25);
        tree.add(20);
        tree.add(27);
        tree.add(15);
        tree.add(22);
        tree.add(26);
        tree.add(30);
        tree.add(29);
        tree.add(32);

        // 25 20 15 22 27 26 30 29 32
        assertEquals("[25, 20, 15, 22, 27, 26, 30, 29, 32]", tree.preOrder().toString());
    }

    @Test
    public void testPostOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(25);
        tree.add(20);
        tree.add(27);
        tree.add(15);
        tree.add(22);
        tree.add(26);
        tree.add(30);
        tree.add(29);
        tree.add(32);

        // 15 22 20 26 29 32 30 27 25
        assertEquals("[15, 22, 20, 26, 29, 32, 30, 27, 25]", tree.postOrder().toString());
    }

    @Test
    public void testContains_doesExist() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(25);
        tree.add(20);
        tree.add(27);
        tree.add(15);
        tree.add(22);
        tree.add(26);
        tree.add(30);
        tree.add(29);
        tree.add(32);

        assertTrue(tree.contains(26));
    }

    @Test
    public void testContains_doesNotExist() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(25);
        tree.add(20);
        tree.add(27);
        tree.add(15);
        tree.add(22);
        tree.add(26);
        tree.add(30);
        tree.add(29);
        tree.add(32);

        assertFalse(tree.contains(24));
    }

    @Test
    public void testTraverseBreadthFirst() {
        //       2
        //     /  \
        //    7    5
        //   / \    \
        //  2  6     9

        Tree<Object> tree = new Tree<>();

        tree.root = new TreeNode<>(2);
        tree.root.left = new TreeNode<>(7);
        tree.root.right = new TreeNode<>(5);
        tree.root.left.left = new TreeNode<>(2);
        tree.root.left.right = new TreeNode<>(6);
        tree.root.right.right = new TreeNode<>(9);

        Tree<TreeNode> t = new Tree<>();

        assertEquals("[2, 7, 5, 2, 6, 9]", t.BinaryTreeBreadthFirst(tree).toString());
    }

    @Test
    public void testFindMaxValue_test1() {
        //       2
        //     /  \
        //    7    5
        //   / \    \
        //  2  6     9

        Tree<Object> tree = new Tree<>();

        tree.root = new TreeNode<>(2);
        tree.root.left = new TreeNode<>(7);
        tree.root.right = new TreeNode<>(5);
        tree.root.left.left = new TreeNode<>(2);
        tree.root.left.right = new TreeNode<>(6);
        tree.root.right.right = new TreeNode<>(9);

        Tree<Object> t = new Tree<>();

        assertEquals((Integer) 9, t.findMaxValue(tree));
    }

    @Test
    public void testFindMaxValue_test2() {
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    19

        Tree<Object> tree = new Tree<>();

        tree.root = new TreeNode<>(10);
        tree.root.left = new TreeNode<>(15);
        tree.root.right = new TreeNode<>(23);
        tree.root.left.left = new TreeNode<>(22);
        tree.root.left.right = new TreeNode<>(6);
        tree.root.right.right = new TreeNode<>(19);

        Tree<Object> t = new Tree<>();

        assertEquals((Integer) 23, t.findMaxValue(tree));
    }

    @Test
    public void testCountLeafNodes() {
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    19

        Tree<Object> tree = new Tree<>();

        tree.root = new TreeNode<>(10);
        tree.root.left = new TreeNode<>(15);
        tree.root.right = new TreeNode<>(23);
        tree.root.left.left = new TreeNode<>(22);
        tree.root.left.right = new TreeNode<>(6);
        tree.root.right.right = new TreeNode<>(19);

        Tree<Object> t = new Tree<>();

        System.out.println(t.getLeafCount(tree));
    }
}
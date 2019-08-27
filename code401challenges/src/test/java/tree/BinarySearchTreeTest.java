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
}
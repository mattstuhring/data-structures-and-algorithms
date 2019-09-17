package code401challenges;

import org.junit.Test;
import tree.Tree;
import tree.TreeNode;

import static org.junit.Assert.*;

public class TreeIntersectionTest {

    @Test
    public void testTreeIntersection_twoEmptyTrees() {
        Tree<Integer> tree1 = new Tree<>();
        Tree<Integer> tree2 = new Tree<>();

        assertEquals("[]", TreeIntersection.treeIntersection(tree1, tree2).toString());
    }

    @Test
    public void testTreeIntersection_oneEmptyTree() {
        Tree<Integer> tree1 = new Tree<>();
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    19

        tree1.root = new TreeNode<>(10);
        tree1.root.left = new TreeNode<>(15);
        tree1.root.right = new TreeNode<>(23);
        tree1.root.left.left = new TreeNode<>(22);
        tree1.root.left.right = new TreeNode<>(6);
        tree1.root.right.right = new TreeNode<>(19);

        Tree<Integer> tree2 = new Tree<>();

        assertEquals("[]", TreeIntersection.treeIntersection(tree1, tree2).toString());
    }

    @Test
    public void testTreeIntersection_allSameValues() {
        Tree<Integer> tree1 = new Tree<>();
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    19

        tree1.root = new TreeNode<>(10);
        tree1.root.left = new TreeNode<>(15);
        tree1.root.right = new TreeNode<>(23);
        tree1.root.left.left = new TreeNode<>(22);
        tree1.root.left.right = new TreeNode<>(6);
        tree1.root.right.right = new TreeNode<>(19);

        Tree<Integer> tree2 = new Tree<>();
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    19

        tree2.root = new TreeNode<>(10);
        tree2.root.left = new TreeNode<>(15);
        tree2.root.right = new TreeNode<>(23);
        tree2.root.left.left = new TreeNode<>(22);
        tree2.root.left.right = new TreeNode<>(6);
        tree2.root.right.right = new TreeNode<>(19);

        // [22, 15, 6, 10, 23, 19]
        assertEquals("[22, 15, 6, 10, 23, 19]", TreeIntersection.treeIntersection(tree1, tree2).toString());
    }

    @Test
    public void testTreeIntersection_firstValueTheSame() {
        Tree<Integer> tree1 = new Tree<>();
        //       10
        //     /  \
        //    18    24
        //   / \    \
        //  21  7    18

        tree1.root = new TreeNode<>(10);
        tree1.root.left = new TreeNode<>(18);
        tree1.root.right = new TreeNode<>(24);
        tree1.root.left.left = new TreeNode<>(21);
        tree1.root.left.right = new TreeNode<>(7);
        tree1.root.right.right = new TreeNode<>(18);

        Tree<Integer> tree2 = new Tree<>();
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    19

        tree2.root = new TreeNode<>(10);
        tree2.root.left = new TreeNode<>(15);
        tree2.root.right = new TreeNode<>(23);
        tree2.root.left.left = new TreeNode<>(22);
        tree2.root.left.right = new TreeNode<>(6);
        tree2.root.right.right = new TreeNode<>(19);

        // [10]
        assertEquals("[10]", TreeIntersection.treeIntersection(tree1, tree2).toString());
    }

    @Test
    public void testTreeIntersection_multipleValuesTheSame() {
        Tree<Integer> tree1 = new Tree<>();
        //       10
        //     /  \
        //    15    24
        //   / \    \
        //  21  7    18

        tree1.root = new TreeNode<>(10);
        tree1.root.left = new TreeNode<>(15);
        tree1.root.right = new TreeNode<>(24);
        tree1.root.left.left = new TreeNode<>(21);
        tree1.root.left.right = new TreeNode<>(7);
        tree1.root.right.right = new TreeNode<>(18);

        Tree<Integer> tree2 = new Tree<>();
        //       10
        //     /  \
        //    15    23
        //   / \    \
        //  22  6    18

        tree2.root = new TreeNode<>(10);
        tree2.root.left = new TreeNode<>(15);
        tree2.root.right = new TreeNode<>(23);
        tree2.root.left.left = new TreeNode<>(22);
        tree2.root.left.right = new TreeNode<>(6);
        tree2.root.right.right = new TreeNode<>(18);

        // [15, 10, 18]
        assertEquals("[15, 10, 18]", TreeIntersection.treeIntersection(tree1, tree2).toString());
    }
}
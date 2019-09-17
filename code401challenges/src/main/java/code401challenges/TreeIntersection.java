package code401challenges;

import hashtable.Hashtable;
import tree.Tree;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeIntersection {

    public static List<String> treeIntersection(Tree tree1, Tree tree2) {
        Hashtable ht = new Hashtable(1024);
        List<String> result = new ArrayList<>();

        for (Object value : tree1.inOrder()) {
            ht.add(String.valueOf(value), String.valueOf(value));
        }

        for (Object value : tree2.inOrder()) {
            if (ht.contains(String.valueOf(value))) {
                result.add(String.valueOf(value));
            }
        }

        return result;
    }
}

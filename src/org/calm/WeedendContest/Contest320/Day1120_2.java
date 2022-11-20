package org.calm.WeedendContest.Contest320;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/11/20
 * @version 1.0
 * ------------------------
 */
public class Day1120_2 {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>(Set.of(-1));
        closestNodes(root, set);
        return queries.stream().map(t -> List.of(set.floor(t), set.ceiling(t) == null ? -1 : set.ceiling(t))).toList();
    }

    private void closestNodes(TreeNode root, TreeSet<Integer> set) {
        if (root != null) {
            set.add(root.val);
            closestNodes(root.left, set);
            closestNodes(root.right, set);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

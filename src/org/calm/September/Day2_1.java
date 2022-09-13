package org.calm.September;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/9/2
 * @version: v1.0
 * ---------------------------
 */
public class Day2_1 {
    int res;
    int newTarget;
    int diff;
    public int closestValue(TreeNode root, double target) {
        newTarget = (int)Math.round(target);
        res = root.val;
        diff = Integer.MAX_VALUE;
        dfs(root, diff);
        return diff;
    }
    void dfs(TreeNode root, int diff) {
        if (root == null) return;
        int curDiff = Math.abs(root.val - newTarget);
        if (curDiff < diff) {
            diff = curDiff;
            res = root.val;
        }
        dfs(root.left, diff);
        dfs(root.right, diff);
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
}

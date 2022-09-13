package org.calm.july;



/**
 * ---------------------------
 * 222. medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/27
 * @version: v1.0
 * ---------------------------
 */
public class Day0727_2_complete_tree {

    public int countNodes(TreeNode root) {

        TreeNode t = root;
        int h = 0;
        while (t.left != null) {
            h++;
            t = t.left;
        }
        // 最小值 2^h, 最大值2^(h + 1) - 1
        // int low = 1 << level, high = (1 << (level + 1)) - 1;
        int l = 1 << h, r = (1 << (h + 1)) - 1;
        while (l < r) {
            int m = (r - l + 1) / 2 + l;
            if (exists(root, h, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    boolean exists(TreeNode root, int h, int m) {
        TreeNode t = root;
        int bits = 1 << (h - 1);
        while (t != null && bits > 0) {
            if ((bits & m) == 0) {
                t = t.left;
            } else {
                t = t.right;
            }
            bits >>= 1;
        }
        return t != null;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;


}



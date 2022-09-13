package org.calm.june;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/27
 * @version: v1.0
 * ---------------------------
 */
public class Day0627_3 {
    public static void main(String[] args) {

    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (p.val > q.val) lowestCommonAncestor(root, q, p);
//
//        List<Integer> list = new ArrayList<>();
//        inOrder(root, list);
//        if (list != null && list.size() > 0) {
//            if (q.val == root.val || q.val > root.val && p.val < root.val) {
//                return root;
//            }
//
//
//        }
//
//    }
//
//    void inOrder(TreeNode root, List<Integer> list) {
//        if (root == null) return;
//        inOrder(root.left);
//        list.add(root.val);
//        inOrder(root.right);
//
//    }
//}
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
}

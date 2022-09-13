//package org.calm.six;
//
///**
// * ---------------------------
// * p450.medium
// * ---------------------------
// * @author: liyang
// * @date: 2022/6/2
// * @version: v1.0
// * ---------------------------
// */
//public class Day0602 {
//    TreeNode pre = null;
//    public static void main(String[] args) {
//
//    }
//    public TreeNode deleteNode(TreeNode root, int key) {
//      TreeNode node = dfs(root, key);
//    }
//
//    void dfs(TreeNode root, int key) {
//
//        if (root == null) {
//            return;
//        }
//        if (root.val == key) {
//            if (pre == null) {
//                dfs2(root);
//            }else {
//                dfss(pre);
//            }
//        }
//
//        pre = root;
//        if (root.val < key) {
//            dfs(root.right, key);
//        } else {
//            dfs(root.left, key);
//        }
//
//    }
//
//    TreeNode dfs2(TreeNode root) {
//        root.right = dfs2(root.right);
//    }
//}
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//

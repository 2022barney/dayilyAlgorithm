package org.calm.june;


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
public class Day0627_2 {
    // -2147483648
    // [-2147483648]

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        String s = Integer.toBinaryString(Integer.MIN_VALUE);
        System.out.println(s.length());
        System.out.println(Integer.MIN_VALUE);
    }
    //Map<Integer, Integer> map = new HashMap<>();
    //boolean flag = false;
    //public boolean findTarget(TreeNode root, int k) {
    //    if (root == null) return
    //    dfs(root, k);
    //}
    //
    //void dfs(TreeNode root, int k) {
    //    if (root == null) return;
    //
    //    if (map.containsKey(k - root.val)) flag = true;
    //    map.put(root.val, -1);
    //    dfs(root.left);
    //    dfs(root.right);
    //}
}
package org.calm.September;




/**
 * ---------------------------
 * 687.medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/9/2
 * @version: v1.0
 * ---------------------------
 */
public class Day2 {
    public static void main(String[] args) {
        double a = 3.114286;
        int ceil = (int)Math.round(a);
        int b = 2;
        System.out.println(ceil);
    }

    /**
     * 模版：非自顶向下
     */


    //int res=0;
    //int maxPath(TreeNode *root) //以root为路径起始点的最长路径
    //{
    //    if (!root)
    //        return 0;
    //    int left=maxPath(root->left);
    //    int right=maxPath(root->right);
    //    res = max(res, left + right + root->val); //更新全局变量
    //    return max(left, right);   //返回左右路径较长者
    //}


    /**
     * 模版：自顶向下
      */

    /**
     * 一般路径：
     * vector<vector<int>>res;
     * void dfs(TreeNode*root,vector<int>path)
     * {
     *     if(!root) return;  //根节点为空直接返回
     *     path.push_back(root->val);  //作出选择
     *     if(!root->left && !root->right) //如果到叶节点
     *     {
     *         res.push_back(path);
     *         return;
     *     }
     *     dfs(root->left,path);  //继续递归
     *     dfs(root->right,path);
     * }
     *
     * # **给定和的路径：**
     * void dfs(TreeNode*root, int sum, vector<int> path)
     * {
     *     if (!root)
     *         return;
     *     sum -= root->val;
     *     path.push_back(root->val);
     *     if (!root->left && !root->right && sum == 0)
     *     {
     *         res.push_back(path);
     *         return;
     *     }
     *     dfs(root->left, sum, path);
     *     dfs(root->right, sum, path);
     * }
     */

    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.val == root.left.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
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



package org.calm.specialAlgorithm;

/**
 * ---------------------------
 * 二维数组的前缀和
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/13
 * @version: v1.0
 * ---------------------------
 */
public class TwoDPresum {

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] presums = getPresums(a);
        for (int[] presum : presums) {
            for (int i : presum) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    //计算二维数组前缀和，用于求一个正方形面积, 应该和容斥定理相关,也是一种dp的思想
   public static int[][] getPresums(int[][] arr) {
       int m = arr.length;
       int n = arr[0].length;
       int[][] dp = new int[m + 1][n + 1];
       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i - 1][j - 1];
           }
       }

       return dp;
   }

}

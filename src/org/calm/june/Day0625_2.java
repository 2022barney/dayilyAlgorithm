package org.calm.june;

/**
 * ---------------------------
 * 剑指 Offer II 091. 粉刷房子
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/25
 * @version: v1.0
 * ---------------------------
 */
public class Day0625_2 {
    /**
     * [[3,5,3],[6,17,6],[7,13,18],[9,10,18]]
     * [[5,8,6],     5    5
     * [19,14,13],   13   13
     * [7,5,12],     5    7
     * [14,15,17],   14   15
     * [3,20,10]]    10   3
     *               57   43
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int houseNum = costs.length;
        int[][] dp = new int[houseNum][3];
        dp[0] = new int[]{costs[0][0], costs[0][1], costs[0][2]};
        for (int i = 1; i < houseNum; i++) {
            int[] pre = dp[i - 1];
            int[] cur = costs[i];
            dp[i] = new int[]{Math.min(cur[0] + pre[1], cur[0] + pre[2]),
                              Math.min(cur[1] + pre[0], cur[1] + pre[2]),
                              Math.min(cur[2] + pre[0], cur[2] + pre[1]),};
        }
        int ans = dp[houseNum - 1][0];
        for (int i = 1; i < 3; i++) {
            ans = Math.min(ans, dp[houseNum - 1][i]);
        }
        return ans;
    }
}
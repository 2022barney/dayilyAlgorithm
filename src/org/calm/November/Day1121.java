package org.calm.November;
/**
 * ------------------------
 *808。medium
 * ------------------------
 * @author liyang
 * @date 2022/11/21
 * @version 1.0
 * ------------------------
 */
public class Day1121 {
    // 动态规划,自底向上
    // 时间复杂度O(C^2),存在常数C = 192使得当n > C时，所求的概率和1的误差在10^-5以内。
    // 空间复杂度: O(C^2)
    /**
     * dp[i][j]表示汤A和汤B分别剩下i和j份时所求的概率值，
     * 即汤A先分配完的概率 + 汤A和汤B同时分配完的概率除以2。
     * 状态转移方程为:
     * dp[i][j] = 1/4 * (dp[i-4][j] + dp[i-3][j - 1] + dp[i - 2][j - 2] + dp[i - 1][j - 3])
     * 边界条件:
     * 当满足i > 0, j = 0, 此时无法要求的概率无法满足，dp[i][j] = 0
     * 当满足i = 0, j = 0, 汤A和汤B同时完成分配的概率为1.0,汤A先完成分配的概率0，因此dp[i][j] = 1.0 * 0.5 = 0.5
     * 当满足i = 0, j > 0, 此时汤A先分配完成，概率为1.0, 因此dp[i][j] = 1.0
     * <p>
     * 根据期望， 汤A: E(A) = (4 + 3 + 2 + 1) * 0.25 = 2.5
     * 汤B: E(B) = (0 + 1 + 2 + 3) * 0.25 = 1.5
     * E(A) > E(B)，因此n无穷大时，汤A大概率比B先分配完，概率接近1。
     * <p>
     * 临界值 n >= 4475
     *
     * @param n
     * @return
     */
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }

        return dp[n][n];
    }
    // 记忆化搜索，自顶向下, 减少许多无效状态
    // 时间复杂度和空间复杂度都是O(C^2)
    private double[][] memo;

    public double soupServings2(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        memo = new double[n + 1][n + 1];
        return dfs(n, n);
    }

    public double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        } else if (a <= 0){
            return 1;
        } else if (b <= 0) {
            return 0;
        }

        if (memo[a][b] == 0) {
            memo[a][b] = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        }
        return memo[a][b];
    }
}

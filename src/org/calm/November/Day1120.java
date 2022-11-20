package org.calm.November;
/**
 * ------------------------
 *799。medium 香槟塔
 * ------------------------
 * @author liyang
 * @date 2022/11/20
 * @version 1.0
 * ------------------------
 */
public class Day1120 {

    /**
     * 定义 f[i][j]为第i行第j列杯子所经过的水的流量， 起始有f[0][0] = k, 最终答案为min(f[n][m], 1);
     * @param k
     * @param n
     * @param m
     * @return 时间复杂度 O(n^2)
     */
    public double champagneTower(int k, int n, int m) {
        double[][] f = new double[n + 10][n + 10];

        f[0][0] = k;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (f[i][j] <= 1) continue;
                f[i + 1][j] += (f[i][j] - 1) / 2;
                f[i + 1][j + 1] += (f[i][j] - 1) / 2;
            }
        }

        return Math.min(f[n][m], 1);
    }
}

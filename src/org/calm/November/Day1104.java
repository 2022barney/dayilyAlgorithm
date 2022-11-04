package org.calm.November;
/**
 * ------------------------
 *754.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/4
 * @version 1.0
 * ------------------------
 */
public class Day1104 {

    /**
     * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
     *
     * 你可以做一些数量的移动 numMoves :
     *
     * 每次你可以选择向左或向右移动。
     * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
     * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
     *
     * -109 <= target <= 109
     * target != 0
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        int t = Math.abs(target);
        int l = 0, r = (int)1e9;
        // 2  3
        while (l + 1 < r) {
            long m = l + r >> 1;
            long des = (m + 1) * m / 2;
            if (des < t) {
                l = (int)m;
            } else {
                r = (int)m;
            }
        }
        int sum = (1 + r) * r / 2;
        return (sum - t) % 2 == 0 ? r : r + 1 + r % 2;

    }
}

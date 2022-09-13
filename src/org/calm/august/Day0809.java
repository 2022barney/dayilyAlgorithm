package org.calm.august;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/9
 * @version: v1.0
 * ---------------------------
 */
public class Day0809 {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] presums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presums[i + 1] = presums[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, presums[i]);
        }
        return ans < 0 ? 1 - ans : 1;
    }
}

package org.calm.November;

import java.util.HashSet;
import java.util.Set;

/**
 * ------------------------
 *805.hard
 * ------------------------
 * @author liyang
 * @date 2022/11/14
 * @version 1.0
 * ------------------------
 */
public class Day1114 {
    // 折半搜索

    // sum(A) / k = sum(nums) / n
    // 时间复杂度：O(n * 2^(n/2)) n数组长度，求出每个子集的元素之和
    // 一共有2 * 2^(n/2) 个子集
    // 空间复杂度：O(2^(n/2))
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, m = n / 2;
        if (n == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = n * nums[i] - sum;
        }
        Set<Integer> left = new HashSet<>();

        for (int i = 1; i < (1 << m); i++) {
            int tot = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0) {
                return true;
            }
            left.add(tot);
        }

        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }

        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    tot += nums[j];
                }
            }

            if (tot == 0 || (rsum != tot && left.contains(-tot))) {
                return true;
            }
        }
        return false;
    }
}

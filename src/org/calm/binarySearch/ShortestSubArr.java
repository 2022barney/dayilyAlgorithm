package org.calm.binarySearch;

import java.util.Arrays;

/**
 * ---------------------------
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/28
 * @version: v1.0
 * ---------------------------
 */
public class ShortestSubArr {
    //7
    //[]
    // 1, 2, 2, 3, 3, 4
    //输出
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 15;
        System.out.println(minSubArrayLen(target, nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        // 前缀和 + 二分
        int n = nums.length;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        //15
        //[1, 2, 3, 4, 5, 6]
        //0, 1, 3, 6, 10, 15, 21
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int t = target + sums[i];
            int l = i + 1, r = n - 1;
            while (l < r) {
                int m =  (r + l + 1) / 2 ;
                if (sums[m] > t) {
                    r = m -  1;
                } else {
                    l = m;
                }
            }
            if (sums[l] - sums[i] >= t) {
                ans = Math.min(ans, l - i + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}

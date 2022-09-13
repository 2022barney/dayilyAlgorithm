package org.calm.june;

import java.util.Arrays;

/**
 * ---------------------------
 * p473,medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/1
 * @version: v1.0
 * ---------------------------
 */
public class Day0601 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean makesquare = solution.makesquare(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3});
        //boolean makesquare = solution.makesquare(new int[]{3, 3, 3, 3, 4});
        //boolean b = containsDuplicate(new int[]{1, 2, 3, 1});
        //System.out.println(b);
    }

    public boolean makesquare(int[] matchsticks) {
        int totalSum = Arrays.stream(matchsticks).sum();
        int sideLength = totalSum / 4;
        if (sideLength * 4 != totalSum) {
            return false;
        }
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, sideLength);
    }
    private boolean dfs(int index, int[] matchsticks, int[] edges, int sideLength) {
        if (index == matchsticks.length) {
            return edges[0] == edges[1] && edges[1] == edges[2] && edges[2] == edges[3];
        }
        for (int i = 0; i < 4; i++) {
            if (edges[i] + matchsticks[index] <= sideLength) {
                edges[i] += matchsticks[index];
                if (dfs(index + 1, matchsticks, edges, sideLength)) {
                    return true;
                }
                edges[i] -= matchsticks[index];
            }
        }
        return false;
    }
    public static boolean containsDuplicate(int[] nums) {
        long count = Arrays.stream(nums).distinct().count();
        System.out.println(count);
        return count != nums.length;
    }
    public int maxSubArray(int[] nums) {
        /**
         * [-2,1,-3,4,-1,2,1,-5,4]
         */
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
        /**
         * i = 1
         * dp[i] = dp[i - 1] + nums[i] dp[i - 1] >0
         *        nums[i]  dp[i - 1] <= 0
         *
         *        状态转移方程
         */
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         *  i, j
         *  if (nums1[i] <= nums2[j])
         *  i++;
         *  else
         */
        if (n == 0) {
            return;
        }
        int i = 0, j = 0;
        while(i < m && j < n) {
            while (nums1[i] <= nums2[j] && i < m) {
                i++;
            }
            if (i == m) {
                for (int k = m + 1; k < m + n; k++) {
                    nums1[k] = nums2[k - m - 1];
                }
                break;
            }
            swap(i, m - 1, nums1);
            nums1[i] = nums2[j];
            i++;
            j++;

        }
    }

    private void swap(int start, int end, int[] nums) {
        for (int i = end; i >= start; i--) {
            int tmp = nums[end + 1];
            nums[end + 1] = nums[end];
            nums[end] = tmp;
        }
    }
}

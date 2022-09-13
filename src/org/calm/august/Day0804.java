package org.calm.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/4
 * @version: v1.0
 * ---------------------------
 */
public class Day0804 {
    public List<Integer> minSubsequence(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        Arrays.sort(copy);
        int sum = (int)Arrays.stream(copy).sum();
        int cur = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            cur += copy[i];
            ans.add(nums[i]);
            if (cur > sum - cur) {
                break;
            }
        }
        return ans;


    }
}

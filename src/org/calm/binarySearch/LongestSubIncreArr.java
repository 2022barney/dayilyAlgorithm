package org.calm.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * 300.medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/20
 * @version: v1.0
 * ---------------------------
 */
public class LongestSubIncreArr {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3});
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
            } else {
                int l = -1, r = list.size();
                while (l + 1< r) {
                    int m = l + r >> 1;
                    if (list.get(m) < nums[i]) {
                        l = m ;
                    } else {
                        r = m;
                    }
                }
                if (list.get(r) >= nums[i]) {
                    list.set(r, nums[i]);
                }
            }
        }
        return list.size();
    }
}

package org.calm.december;

import java.util.Arrays;

/**
 * ------------------------
 *1760.medium  袋子里最少数目的球
 * ------------------------
 * @author liyang
 * @date 2022/12/20
 * @version 1.0
 * ------------------------
 */
public class Day1220 {

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 0, r = Arrays.stream(nums).max().getAsInt() + 1;
        while (l + 1 < r) {
            int m = l + r >> 1;

            if (check(m, nums) <= maxOperations) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }

    int check(int m, int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += (num - 1) / m;
        }
        return ans;
    }
}

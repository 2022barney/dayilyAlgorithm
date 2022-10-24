package org.calm.October;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/24
 * @version 1.0
 * ------------------------
 */
public class Day1024 {
    /**
     * left 中的每个元素都小于或等于 right 中的每个元素。
     * left 和 right 都是非空的。
     * left 的长度要尽可能小。
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int c = Math.max(left[i - 1], nums[i]);
            left[i] = c;
        }

        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int c = Math.min(right[i + 1], nums[i]);
            right[i] = c;
        }

        for (int i = 0; i < n - 1; i++) {
            if (left[i] <= right[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}

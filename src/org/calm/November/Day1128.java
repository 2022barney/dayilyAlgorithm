package org.calm.November;
/**
 * ------------------------
 *494.目标和 回溯
 * ------------------------
 * @author liyang
 * @date 2022/11/28
 * @version 1.0
 * ------------------------
 */
public class Day1128 {
    /**
     * 1 <= nums.length <= 20
     * 0 <= nums[i] <= 1000
     * 0 <= sum(nums[i]) <= 1000
     * -1000 <= target <= 1000
     */
    static int count = 0;

    public static void main(String[] args) {
        findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public static void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}


package org.calm.November;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------
 * 775.medium 全局倒置及局部倒置
 * ------------------------
 * @author liyang
 * @date 2022/11/16
 * @version 1.0
 * ------------------------
 */
public class Day1116 {

    // 解法1: 全局倒置包含局部倒置，全局倒置即 nums[i] > nums[j], j > i + 1
    // 此时遍历
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length, min = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(min, nums[i + 1]);
        }
        return true;
    }
    // 解法2：归纳证明

    /**
     * 如果是没有全局倒置，则不存在nums[i] > nums[j], j > i + 1
     * 此时0只能位于下标0或者1，即<2；
     * 1、0位于下标0，问题转换为[1, n-1]的子问题
     * 2、nums[1] = 0, 如果nums[0] 只能为 1,如果是任何大于1的数，都会和后面的1构成非局部倒置，
     * 此时问题转换为[2, n - 1]区间的子问题
     * 重复上述即可归纳出【理想排列】的充分必要条件为对于每个元素nums[i]满足|nums[i] - i| <= 1
     * @param nums
     * @return
     */
    public boolean isIdealPermutation2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - 1) > 1) return false;
        }
        return true;
    }

}

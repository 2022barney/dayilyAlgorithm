package org.calm.binarySearch;

import java.util.Arrays;

/**
 * ---------------------------
 * 611 medium
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/28
 * @version: v1.0
 * ---------------------------
 */
public class Triangle {
    //输入: nums = [2,2,3,4]
    //输出: 3
    //解释:有效的组合是:
    //2,3,4 (使用第一个 2)
    //2,3,4 (使用第二个 2)
    //2,2,3

    //输入: nums = [4,2,3,4]
    //输出: 4
    //[24,3,82,22,35,84,19]
    // 10
    // 5
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{24,3,82,22,35,84,19}));
        //System.out.println(triangleNumber(new int[]{82,15,23,82,67,0,3,92,11}));
        //System.out.println(triangleNumber(new int[]{2, 2, 3, 4}));
    }
    public static int triangleNumber(int[] nums) {
        // 2,2,3,4
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < n - 1; j++) {
                int target = nums[i] + nums[j];
                int l = j + 1, r = n -1;
                while(l < r) {
                    int m = (l + r + 1) / 2;
                    if (nums[m] > target) {
                        r = m - 1;
                    } else {
                        l = m;
                    }
                }
                if (nums[l] <= target) {
                    while (nums[l] == target) {
                        l--;
                    }
                    if (l > j) {
                        ans += l - j ;
                    }
                }
            }
        }
        return ans;
    }
}

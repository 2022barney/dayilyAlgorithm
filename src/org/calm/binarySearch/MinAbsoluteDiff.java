package org.calm.binarySearch;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/4
 * @version: v1.0
 * ---------------------------
 */
public class MinAbsoluteDiff {

    public static void main(String[] args) {

    }

    int MOD = 1000000000 + 7;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] arr = Arrays.copyOf(nums1, n);
        Arrays.sort(arr);
        long sum = 0;
        int maxMinus = 0;
        for (int i = 0; i < n; i++) {
            int curDiff = Math.abs(nums1[i] - nums2[i]);
            sum += curDiff;
            if (curDiff != 0) {
                int l = 0, r = n - 1;
                while(l < r) {
                    int m = l + (r - l) / 2;
                    if (arr[m] < nums2[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                int curMinus = 0;
                if (arr[l] == nums2[i]) {
                    curMinus = curDiff;
                } else {
                    if (l == 0 || l == n - 1) {
                        if(l == 0) {
                            curMinus = curDiff - Math.min(Math.abs(nums2[i] - arr[l]), Math.abs(nums2[i] - arr[l + 1]));
                        } else if (l == n - 1) {
                            curMinus = curDiff - Math.min(Math.abs(nums2[i] - arr[l]), Math.abs(nums2[i] - arr[l - 1])) ;
                        }

                    }else {
                        curMinus = curDiff - Math.min(Math.abs(nums2[i] - arr[l]), Math.abs(nums2[i] - arr[l - 1])) ;
                    }
                }
                maxMinus = Math.max(maxMinus, curMinus);
            }

        }
        // int 在最外面
        return (int)((sum - maxMinus) % MOD);
    }
}

package org.calm.binarySearch;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/25
 * @version: v1.0
 * ---------------------------
 */
public class TwoArrMinus {

    public int maxDistance(int[] nums1, int[] nums2) {
        if (nums2[nums2.length - 1] > nums1[0]) return nums2.length - 1;
        if (nums1[nums1.length - 1] >= nums2[0]) return 0;

        /**
         * [2,2,2]
         * [10,10,1]
         */
        //int i = 0, j = nums2.length - 1;
        //int ans = 0;
        //while (i < nums1.length && j >= 0) {
        //    while (nums1[i] > nums2[j] && i < Math.min(nums1.length - 1, j)) i++;
        //    ans = Math.max(ans, j - i);
        //    j--;
        //}
        int n1 = nums1.length;
        int n2 = nums2.length;
        int pre = n2 - 1;
        int ans = 0;
        for (int i = n2 -1; i >= 0; i++) {
           int l = 0, r = Math.min(n1 - 1, pre);
           while (l < r) {
               int m = l + (r - l) / 2;
               if (nums1[m] < nums2[i]) {
                   l = m + 1;
               }else {
                  r = m;
               }
           }
           ans = Math.max(ans, i - l);
           pre = l;
        }
        return ans;


    }
}

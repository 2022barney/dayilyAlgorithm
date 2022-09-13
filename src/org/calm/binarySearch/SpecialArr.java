package org.calm.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ---------------------------
 * T1608 easy
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/21
 * @version: v1.0
 * ---------------------------
 */
public class SpecialArr {
    //3,5
    //2
    //0
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> integers = list.subList(0, 1);
        System.out.println(integers.size());
        int[] arr = {0, 0, 3, 4, 4};
        //int t = specialArray(arr);
    }
    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int l = 1, r = nums[n];
        while (l <= r) {
            int m = l + (r - l) / 2;
            int x = count(m, nums);
            if (x == m) {
                return x;
            }
            if ( x < m ) {
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        //System.out.println("l: " + l);
        //System.out.println("r: " + r);
        return -1;
    }

    public static int count(int t, int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > t) {
                r = m ;
            }else {
                l = m + 1;
            }
        }
        System.out.println(l);
        return nums.length - l;
    }

    public static int test(int[] nums, int target) {
        int l = 0, r = nums.length ;
        // 0, 1, 2, 3
        // 0
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m;
            }else {
                l = m + 1;
            }
        }
        System.out.println(l);
        return l;
    }
}

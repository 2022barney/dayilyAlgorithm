package org.calm.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/29
 * @version: v1.0
 * ---------------------------
 */
public class Day0629 {

    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr.length == 1) {
            res.add(arr[0]) ;
            return  res;
        }

        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int left = l;
        l = 0;
        r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (arr[m] > x) {
                r= m - 1;
            } else {
                l = m;
            }
        }
        int right = l;

        if (left == right) {
            res.add(arr[left]);
            int l1 = left - 1;
            int r1 = right + 1;
            int cnt = 1;
            while (cnt < k && l1 >= 0 && r1 < arr.length) {
                if (Math.abs(arr[l1] - x) <= Math.abs(arr[r1] - x)) {
                    res.add(arr[l1--]);
                } else {
                    res.add(arr[r1--]);
                }
            }
            return res;
        } else  {
            if (arr[left] == x) {
                if (right - left + 1 >= k) {
                    for (int i = 0; i < k; i++) {
                        res.add(x);
                    }
                    return res;
                } else {
                    for (int i = 0; i <right - left + 1; i++) {
                        res.add(x);
                    }
                    int cnt = right - left + 1;
                    int l1 = left - 1;
                    int r1 = right + 1;
                    while (cnt < k && l1 >= 0 && r1 < arr.length) {
                        if (Math.abs(arr[l1] - x) <= Math.abs(arr[r1] - x)) {
                            res.add(arr[l1--]);
                        } else {
                            res.add(arr[r1--]);
                        }
                    }
                }
            } else {
                int cnt = 0;
                int l1 = left;
                int r1 = right;
                while (cnt < k && l1 >= 0 && r1 < arr.length) {
                    if (Math.abs(arr[l1] - x) <= Math.abs(arr[r1] - x)) {
                        res.add(arr[l1--]);
                    } else {
                        res.add(arr[r1--]);
                    }
                }
            }
        }
        return res;
        // 1, 3, 5, 7  ==> 6


    }
}

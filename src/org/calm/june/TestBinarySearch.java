package org.calm.june;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/16
 * @version: v1.0
 * ---------------------------
 */
public class TestBinarySearch {

    public static void main(String[] args) {
        //template2();
        int i = 1;
        i = i++ + ++i;
        System.out.println(i);
    }

    public static void template1() {
        int[] arr = {1, 3, 3, 7, 7};
        int n = arr.length;
        int l = 0, r = n - 1;
        int flag = -1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] == 0) {
                flag = mid;
                break;
            }
            if (arr[mid] > 0) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }

        }
        System.out.println(flag);
        System.out.println("l: " + l);
        System.out.println("r: " + r);
    }
    public static void template2() {
        int[] arr = {1, 3, 3, 3, 5, 5, 5, 7};
        int target = 4;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        System.out.println(l);
    }
}

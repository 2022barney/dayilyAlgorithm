package org.calm.july;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/29
 * @version: v1.0
 * ---------------------------
 */
public class Day0729 {

    public static void main(String[] args) {
        boolean b = validSquare(new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 0});
        System.out.println(b);
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        int[][] arr = new int[4][2];
        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;
        arr[3] = p4;
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int a = getLength(arr[0], arr[1]);
        int b = getLength(arr[0], arr[2]);
        int c = getLength(arr[3], arr[1]);
        int d = getLength(arr[3], arr[2]);

        int e = getLength(arr[1], arr[2]);

        boolean flag = (a + b) == e;

        if (a == b && b == c && c == d && d == a && flag) return true;
        return false;

    }

    static int getLength(int[] arr1, int[] arr2) {
        int a = arr1[0];
        int b = arr1[1];
        int c = arr2[0];
        int d = arr2[1];

        return (int)(Math.pow(Math.abs(a - c), 2) + Math.pow(Math.abs(b - d), 2));
    }
}

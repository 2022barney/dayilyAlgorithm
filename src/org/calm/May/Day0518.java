package org.calm.May;

import java.util.Arrays;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/17
 * @version: v1.0
 * ---------------------------
 */
public class Day0518 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{3,2},{2,4},{5,6},{3,5}};
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for (int[] ints : arr) {
            System.out.print(ints[0]);
            System.out.print("-");
            System.out.print(ints[1]);
            System.out.println();
        }
        System.out.println(arr);
    }
}

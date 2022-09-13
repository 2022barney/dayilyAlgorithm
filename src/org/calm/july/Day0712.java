package org.calm.july;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/12
 * @version: v1.0
 * ---------------------------
 */
public class Day0712 {

    public int oddCells(int m, int n, int[][] indices) {
        int[] a1 = new int[m];
        int[] a2 = new int[n];
        for (int[] indice : indices) {
           int i = indice[0];
           int j = indice[1];
           a1[i] ++;
           a2[j] ++;
        }
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < m; i++) {
            if (a1[i] % 2 != 0) {
                c1++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a2[i] % 2 != 0) {
                c2++;
            }
        }
        return c1 * m + c2 * n - 2 * c1 * c2 ;
    }
}

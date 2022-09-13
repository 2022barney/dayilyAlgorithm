package org.calm.binarySearch;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/14
 * @version: v1.0
 * ---------------------------
 */
public class TwoDPeek {

    public int[] findPeakGrid(int[][] mat) {

        int n = mat[0].length;
        int m = mat.length;


        int l = 0, r = m - 1;

        while (l < r) {
            int c = l + r >> 1;
            int maxIndex = getMaxIndex(c, mat[c]);
            if (mat[c][maxIndex] <= mat[c + 1][maxIndex]) {
                l = c + 1;
            } else {
                r = c;
            }
        }
        int maxIndex = getMaxIndex(l, mat[l]);

        return new int[]{l, maxIndex};
    }

    int getMaxIndex(int c, int[] arr) {
        int idx = 0;
        int maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > maxNum) {
                maxNum = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}

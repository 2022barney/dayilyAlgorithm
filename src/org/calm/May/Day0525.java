package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/25
 * @version: v1.0
 * ---------------------------
 */
public class Day0525 {
    public static void main(String[] args) {
        //{{{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}}},{2,1,4,3},{1,1,2,2},{1,2,2,4}}
        int[][] test = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Day0525 day = new Day0525(test);
        day.sumRegion(2, 1, 4, 3);
    }

    static int[][] cnts;

    public  Day0525(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        cnts = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cnts[i][j] = cnts[i - 1][j] + cnts[i][j - 1] - cnts[i - 1][j - 1] + matrix[i - 1][j - 1];

            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return cnts[row2][col2] - cnts[row1 - 1][col2] - cnts[row2][col1 - 1] +
                cnts[row1 - 1][col1 - 1];
    }
}

package org.calm.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: nolai
 * @date: 2022/7/20
 * @version: v1.0
 * ---------------------------
 */
public class Day0720 {
    public static void main(String[] args) {
        System.out.println(4 % 16);
        int[][] t = {{3,8,1,9}, {19,7,2,5}, {4,6,11,10}, {12,0,21,13}};
        int k = 4;
        shiftGrid(t, k);
    }
    //[[],[],[],[]]
    //4
    //输出：
    //[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]
    //预期结果：
    //[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[] tender = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            tender[i] = grid[i / n][i % n];
        }

        int[][] res = grid;

        if (k % (m * n) != 0) {
            k = k % (m * n);
            for (int i = 0; i < m * n; i++) {
                int t = 0;

                if (i < m * n -  k  ) {
                    t = i + k;
                } else {
                    t = i - (m * n - k );
                }

                res[t / n][t % n] = tender[i];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] arr : res) {
            List<Integer> list = new ArrayList<>();
            for (int i : arr) {
                list.add(i);
            }
            ans.add(list);
        }

        return ans;

    }
}

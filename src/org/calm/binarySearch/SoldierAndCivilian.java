package org.calm.binarySearch;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/23
 * @version: v1.0
 * ---------------------------
 */
public class SoldierAndCivilian {
    public static void main(String[] args) {
        int[][] grid = {{2, 3}, {2, 1}};
        List<int[]> collect = Arrays.stream(grid).sorted((a, b) ->
                a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0])
        ).limit(2).collect(Collectors.toList());
        for (int[] ints : collect) {
            System.out.println(ints[1]);
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] grid = new int[m][2];
        //1,1,0,0,0
        //1,0,0,0,0
        // l = 0, r = n - 1 ===> m的值总是趋向左侧(偶数长度偏向左侧中间数，奇数是正中间),
        // 1.防止无限循环，要让l不断加1,找到目标值最右侧的边界
        for (int i = 0; i < m; i++) {
            int[] arr = mat[i];
            int l = 0, r = n - 1;
            while (l < r) {
                int c = l + r >> 1;
                if (arr[c] > 0) {
                     l = c + 1;
                }else {
                     r = c;
                }
            }
            grid[i][0] = arr[l] > 0 ? l + 1 : l;
            grid[i][1] = i;
        }
        //Arrays.sort(grid, (a, b) ->
        //    a[0] == b[0] ? (a[0] - b[0])  : (a[1] - b[1]) );
        Iterator<int[]> iterator = Arrays.stream(grid).sorted((a, b) ->
                a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0])
        ).limit(k).iterator();
        int[] ans = new int[k];
        int i = 0;
        while (iterator.hasNext()) {
            ans[i++] = (int)iterator.next()[1];
        }
        return ans;
    }
}

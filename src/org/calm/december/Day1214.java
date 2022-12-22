package org.calm.december;

import java.util.Arrays;

/**
 * ------------------------
 * <p>
 * ------------------------
 * @author liyang
 * @version 1.0
 * ------------------------
 * @date 2022/12/14
 */
public class Day1214 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        Integer[] idx = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            idx[i] = i;
        }
        //Arrays.sort(idx, (a, b) -> queries[a][2] - queries[b][2]);
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }

        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (Integer i : idx) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }

        return res;

    }

    public int find(int[] uf, int x) {
        if (uf[x] == x) return x;
        return uf[x] = find(uf, uf[x]);
    }

    public void merge(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }

    public static void main(String[] args) {
        int[][] queries = {{3, 2}, {3, 5}, {3, 4}, {3, 1}};
        Integer[] idx = new Integer[queries.length];
        for (int i = 0; i < 4; i++) {
            idx[i] = i;
        }
        //0 2 3 1
        //0 2 1 3
        //0 1 2 3
        //0 3 1 2
        //0 1 2 3
        //0 1 2 3
        //0 3 1 2
        Arrays.sort(idx, (a, b) -> queries[a][1] - queries[b][1]);
        for (int x : idx)
        System.out.print(x + " ");

    }
}

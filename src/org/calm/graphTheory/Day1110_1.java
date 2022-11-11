package org.calm.graphTheory;

import java.util.*;

/**
 * ------------------------
 * 1129.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/10
 * @version 1.0
 * ------------------------
 */
public class Day1110_1 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        // 边的集合转换为临接表
        List<Integer>[] redList = new List[n];
        List<Integer>[] blueList = new List[n];

        for (int i = 0; i < n; i++) {
            redList[i] = new ArrayList<>();
            blueList[i] = new ArrayList<>();
        }

        for (int[] edge : redEdges) {
            redList[edge[0]].add(edge[1]);
        }

        for (int[] edge : blueEdges) {
            blueList[edge[0]].add(edge[1]);
        }

        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];

        Queue<int[]> queue = new LinkedList<>();

        // 0 red, 1 blue
        // 初始0可以走红色和蓝色两条路
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 1, 0});
        redVisited[0] = true;
        blueVisited[0] = true;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int v = x[0], color = x[1], len = x[2];

            if (res[v] == -1) {
                res[v] = len;
            }

            if (color == 0) {
                for (int w : blueList[v]) {
                    if (!blueVisited[w]) {
                        blueVisited[w] = true;
                        queue.add(new int[]{w, 1, len + 1});
                    }
                }
            } else {
                for (int w : redList[v]) {
                    if (!redVisited[w]) {
                        redVisited[w] = true;
                        queue.add(new int[]{w, 0, len + 1});
                    }
                }
            }
        }
        return res;
    }
}

package org.calm.graphTheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ------------------------
 * 547.medium
 * ------------------------
 *
 * @author liyang
 * @version 1.0
 * ------------------------
 * @date 2022/11/8
 */
public class Day1108_1 {
    // dfs
    // 时间复杂度O(n^2)
    // 空间复杂度O(n)
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;

        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }

    void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }
    // bfs
    public int findCircleNum2(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cities; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

}

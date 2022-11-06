package org.calm.graphTheory;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ------------------------
 *1926.medium   bfs
 * ------------------------
 * @author liyang
 * @date 2022/11/6
 * @version 1.0
 * ------------------------
 */
public class Day1106 {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        int ans = 0;
        maze[entrance[0]][ entrance[1]] = '+';
        while (!queue.isEmpty()) {
            ans ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int mx = cur[0] + dirs[j][0];
                    int my = cur[1] + dirs[j][1];
                    if (mx >= 0 && mx < m && my >= 0 && my < n && maze[mx][my] == '.') {
                        if (mx == 0 || mx == m - 1 || my == 0 || my == n - 1) return ans;
                        maze[mx][my] = '+';
                        queue.offer(new int[]{mx, my});
                    }
                }
            }
        }
        return -1;
    }
}

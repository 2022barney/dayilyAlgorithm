package org.calm.graphTheory;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ------------------------
 *1091. medium
 * ------------------------
 * @author liyang
 * @date 2022/11/5
 * @version 1.0
 * ------------------------
 */
public class Day1105_2 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)  {
            return -1;
        }

        int count = 0;
        int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
        int[] dy = {1, 0, 1, 0, -1, 1, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                if (x == n - 1 && y == n - 1) {
                    return count;
                }
                for (int k = 0; k < 8; k++) {
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    if (xx >= 0 && xx < n && yy >= 0 && yy < n && grid[xx][yy] == 0) {
                        queue.offer(new int[]{xx, yy});
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}

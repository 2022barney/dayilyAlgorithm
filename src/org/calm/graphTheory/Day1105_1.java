package org.calm.graphTheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ------------------------
 *542 medium
 * ------------------------
 * @author liyang
 * @date 2022/11/5
 * @version 1.0
 * ------------------------
 */
public class Day1105_1 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < m && my >= 0 && my < n && mat[mx][my] == -1) {
                    mat[mx][my] = mat[x][y] + 1;
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        return mat;
    }
}

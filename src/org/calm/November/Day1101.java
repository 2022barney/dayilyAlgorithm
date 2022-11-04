package org.calm.November;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ------------------------
 * 图论1
 * ------------------------
 * @author liyang
 * @date 2022/11/1
 * @version 1.0
 * ------------------------
 */
public class Day1101 {

    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 1、 bfs
        /*int curColor = image[sr][sc];
        if (curColor == color) {
            return image;
        }

        int n = image.length, m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        image[sr][sc] = color;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m
                && image[mx][my] == curColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }
        return image;*/

        // 2、dfs
        int curColor = image[sr][sc];
        if (curColor != color) {
            dfs(image, sr, sc, curColor, color);
        }
        return image;
    }

    void dfs(int[][] image, int x, int y, int curColor, int color) {
        if (image[x][y] == curColor) {
            image[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length &&
                my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, curColor, color);
                }
            }
        }
    }
}

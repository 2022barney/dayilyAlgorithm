package org.calm.October;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/25
 * @version 1.0
 * ------------------------
 */
public class Day1025 {
    //这一题实际上就两部分组成，第一部分在于标记，区分两座不同的岛屿，第二部分在于搜索，找出两座岛屿的距离，难点在于如何找出两座岛屿的最短距离

    //标记全局变量有利于解题，甚至是解题的关键！
    int m, n;
    int[][] grid;
    Queue<int[]> queue = new LinkedList<>();

    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int shortestBridge(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;

        //first step,标记海岛，由于只需要标记一块海岛，所以要用到块
        A: for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    flagMap(i, j);
                    break A;
                }
            }
        }
        //在标记一块海岛的时候，我们保存下来了这一块海岛的所有位置，所以接下来就是遍历这块海岛的所有位置，一旦move点发现1，就输出记录层数ans
        int ans = 0;
        B: while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int mx = cur[0] + dx[k], my = cur[1] + dy[k];
                    if (mx >= 0 && mx < m && my >= 0 && my < n && grid[mx][my] == 1) {
                        break B;
                    } else if (mx >= 0 && mx < m && my >= 0 && my < n && grid[mx][my] == 0){
                        grid[mx][my] = 2;
                        queue.offer(new int[]{mx, my});
                    }
                }
            }
            ans++;
        }
        return ans;
    }

    //标记不同的海岛，但是需要注意全局queue是用来存储一个岛屿所有点的，方便后面搭桥的时候处理，所以需要新建一个queue来处理
    private void flagMap(int i,int j) {//提供一个入口就可以进行标记
        grid[i][j] = 2;
        Queue<int[]> curqueue = new LinkedList<>();
        curqueue.offer(new int[]{i, j});
        queue.offer(new int[]{i, j});

        while (!curqueue.isEmpty()) {
            int[] cur = curqueue.poll();
            int x = cur[0], y = cur[1];
            for (int k = 0; k < 4; k++) {
                int mx = x + dx[k], my = y + dy[k];
                if (mx >= 0 && mx < m && my >= 0 && my < n && grid[mx][my] == 1) {
                    grid[mx][my] = 2;
                    curqueue.offer(new int[]{mx, my});
                    queue.offer(new int[]{mx, my});
                }
            }
        }
    }
}

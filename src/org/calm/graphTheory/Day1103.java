package org.calm.graphTheory;
/**
 * ------------------------
 * 1254. medium
 * ------------------------
 * @author liyang
 * @date 2022/11/3
 * @version 1.0
 * ------------------------
 */
public class Day1103 {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int m, n;

    private boolean[][] visited;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }

        int ans = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col >= n || col < 0
        || grid[row][col] == 0 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }

    }
}

package org.future.dfs;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2023/1/3
 * @version 1.0
 * ------------------------
 */
public class Dfs_backtrack {

    public static void main(String[] args) {
        new DfsSolution().test(3);
    }


}
class DfsSolution {
    int n;
    int[] path = new int[10];
    boolean[] st = new boolean[10];

    void test(int n) {
        this.n = n;
        dfs(0);
    }

    void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}

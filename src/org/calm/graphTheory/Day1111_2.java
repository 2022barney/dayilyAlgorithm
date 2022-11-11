package org.calm.graphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ------------------------
 * <p>
 * ------------------------
 *
 * @author liyang
 * @version 1.0
 * ------------------------
 * @date 2022/11/11
 */
public class Day1111_2 {
    // bfs
    // 时间复杂度O(n)
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            if (arr[idx] == 0) {
                return true;
            }

            int pre = idx - arr[idx];
            int next = idx + arr[idx];
            if (pre >= 0 && pre < n && !visited[pre]) {
                visited[pre] = true;
                queue.offer(pre);
            }
            if (next >= 0 && next < n && !visited[next]) {
                visited[next] = true;
                queue.offer(next);
            }
        }
        return false;
    }

    // dfs
    public boolean canReach2(int[] arr, int start) {
        int n = arr.length;
        int[] inStack = new int[n];
        List<Integer> ans = new ArrayList<>();
        return dfs(start, arr, inStack);

    }

    boolean dfs(int start, int[] arr, int[] inStack) {
        if (inStack[start] > 0) {
            return arr[start] == 0;
        }

        inStack[start] = 1;

        int pre = start - arr[start];
        int next = start + arr[start];
        boolean f1 = false;
        boolean f2 = false;
        if (pre >= 0 && pre < arr.length) {
            f1 = dfs(pre, arr, inStack);
        }
        if (next >= 0 && next < arr.length) {
            f2 = dfs(next, arr, inStack);
        }

        return f1 || f2;
    }
}
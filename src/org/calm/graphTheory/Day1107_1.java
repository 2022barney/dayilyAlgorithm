package org.calm.graphTheory;

import org.w3c.dom.Node;

import java.util.*;

/**
 * ------------------------
 *797.medium bfs/dfs
 * ------------------------
 * @author liyang
 * @date 2022/11/7
 * @version 1.0
 * ------------------------
 */
public class Day1107_1 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        // bfs从0开始一层一层向外搜索
        List<List<Integer>> res = new ArrayList<>();

        int n = graph.length;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.index == n - 1) {
                res.add(node.path);
                continue;
            }
            for (int next : graph[node.index]) {
                queue.offer(new Node(next, node.path));
            }
        }
        return res;
    }

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    // dfs
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }



        class Node {
        int index;
        List<Integer> path;

        Node(int index) {
            this.index = index;
            this.path = new ArrayList<>();
            // 把当前节点加入路径
            this.path.add(index);
        }

        Node(int index, List<Integer> path) {
            this.index = index;
            // 复制一个新的list
            this.path = new ArrayList<>(path);
            // 把当前节点加入路径
            this.path.add(index);
        }
    }
}

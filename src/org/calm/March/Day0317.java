package org.calm.March;

import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------
 * 回溯算法模板
 * ---------------------------
 *
 * @author：liyang
 * @date：2022/3/17
 * @version: v1.0
 * ---------------------------
 */
public class Day0317 {


    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] c = {2,3,7};
        int target = 7;
        combinationSum(c, target);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, target);
        return res;
    }

    private static void dfs(int[] candidates, int s, int target) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                dfs(candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }

}

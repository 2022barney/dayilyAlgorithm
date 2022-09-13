package org.calm.july;

import java.util.*;

/**
 * ---------------------------
 * 1200. easy
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/4
 * @version: v1.0
 * ---------------------------
 */
public class Day0704 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        Map<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int minus = arr[i + 1] - arr[i];
            map.put(i, minus);
            min = Math.min(min, minus);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[entry.getKey()]);
                list.add(arr[entry.getKey() + 1]);
                ans.add(list);
            }
        }

        return ans;
    }
}

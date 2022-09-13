package org.calm.july;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * ---------------------------
 *
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/28
 * @version: v1.0
 * ---------------------------
 */
public class Day0728 {
    public static void main(String[] args) {
       arrayRankTransform(new int[]{40, 10, 20, 30});
    }

    // [2,-11,24,15,26,-31,-48,-49,22,37,-36]
    // 输出：
    // [6,5,9,7,10,4,6,1,8,11,3]
    //预期结果：
    // [6,5,9,7,10,4,2,1,8,11,3]
    public static int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!set.isEmpty()){
            int i = set.pollFirst();
            if (map.containsKey(i)) {
                continue;
            }
            int size = map.size();
            map.put(i, size + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

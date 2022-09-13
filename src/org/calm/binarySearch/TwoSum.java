package org.calm.binarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 * @author: liyang
 * @date: 2022/6/21
 * @version: v1.0
 * ---------------------------
 */
public class TwoSum {
    // 2,7,11,15
    // 9
    // [5,25,75]
    //100
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            int n1 = numbers[i];
            int n2 = numbers[j];
            if (n1 + n2 == target) {
                return new int[]{i+1, j+1};
            }
           if (map.containsKey(target - n1)) {
               return new int[]{i + 1, map.get(target - n1) + 1};
           }
            if (map.containsKey(target - n2)) {
                return new int[]{map.get(target - n2) + 1, j + 1};
            }
            map.put(n1, i);
            map.put(n2, j);
            i++;
            j--;
        }
        return new int[2];
    }

}

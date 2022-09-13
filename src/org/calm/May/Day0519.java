package org.calm.May;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 * @author: liyang
 * @date: 2022/5/19
 * @version: v1.0
 * ---------------------------
 */
public class Day0519 {

    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        /*Stack<int[]> stack = new Stack<>();

        List<int[]> lab = new ArrayList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int[] arr = new int[2];
            arr[0] = temperatures[i];
            arr[1] = i;
            lab.add(arr);
        }

        for (int[] ints : lab) {
            int tem = ints[0];
            int idx = ints[1];
            while (!stack.isEmpty() && stack.peek()[0] < tem) {
                int[] pop = stack.pop();
                int curIdx = pop[1];
                res[curIdx] = idx - curIdx;
            }
            stack.push(ints);
        }
        return res;*/

        /**
         *   [89,62,70,58,47,47,46,76,100,70]
         */
        int len = temperatures.length;
        int[] res = new int[len];

        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1;
            while (temperatures[i] >= temperatures[j]) {
                if (res[j] == 0) {
                    break;
                }
                j += res[j];
            }
            res[i] = temperatures[j] > temperatures[i] ? j - i : 0;
        }

        return res;
    }
}

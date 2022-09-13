package org.calm.july;

import java.util.Arrays;
import java.util.Stack;

/**
 * ---------------------------
 * 735. medium
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/13
 * @version: v1.0
 * ---------------------------
 */
public class Day0713 {

    // [5, 10, -5]
    //[-2,-1,1,2]
    // -2, -1, 1, 2
    //[-2,-2,1,-2]
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        out:for (int a : asteroids) {
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(a);
            } else {
                if (a > 0) {
                    stack.push(a);
                } else {
                    while (!stack.isEmpty() && a + stack.peek() <= 0 && stack.peek() > 0) {
                        int pop = stack.pop();
                        if (pop + a == 0) {
                            continue out;
                        }
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(a);
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
           ans[idx++] = stack.pop();
        }
        for (int i = 0, j = ans.length - 1; i < j; i++, j--) {
            int t = ans[i];
            ans[i] = ans[j];
            ans[j] = t;
        }
        return ans;
    }
}

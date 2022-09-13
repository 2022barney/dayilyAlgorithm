package org.calm.august;

import java.util.Stack;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/31
 * @version: v1.0
 * ---------------------------
 */
public class Day0831 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        validateStackSequences(pushed, poped);
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int i = 0, j = 0;
        while (i < n) {

            int a = pushed[i];
            while (!stack.isEmpty() && j < n && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            stack.push(a);
        }
        return stack.isEmpty();
    }
}

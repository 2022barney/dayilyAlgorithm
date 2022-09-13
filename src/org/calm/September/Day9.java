package org.calm.September;

import java.util.Stack;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/9/9
 * @version: v1.0
 * ---------------------------
 */
public class Day9 {
    public static void main(String[] args) {

    }

    /**
     * ["d1/","d2/","../","d21/","./"]
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String str : logs) {
            if ("./".equals(str)) {

            }else if ("../".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else {
                stack.push(str);
            }
        }

        return stack.size();
    }
}

package org.calm.November;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ------------------------
 * 1106.hard
 * ------------------------
 * @author liyang
 * @date 2022/11/5
 * @version 1.0
 * ------------------------
 */
public class Day1105 {
    /**
     *-----------------------
     * 栈的应用
     *-----------------------
     * @param expression
     * @return boolean
     *-----------------------
     * @author liyang
     * @date 2022/11/5 18:23
     * @version 1.0
     *----------------------
     */
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                switch (op) {
                    case '!':
                        stack.push(f == 1 ? 't' : 'f');
                        break;
                    case '&':
                        stack.push(f == 0 ? 't' : 'f');
                        break;
                    case '|':
                        stack.push(t == 0 ? 'f' : 't');
                        break;
                    default:
                }
            }
        }
        return stack.pop() == 't';
    }
}

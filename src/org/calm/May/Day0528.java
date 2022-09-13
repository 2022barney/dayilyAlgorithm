package org.calm.May;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/28
 * @version: v1.0
 * ---------------------------
 */
public class Day0528 {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        List<char[]> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(c == '('){
                cnt++;
            }else {
                cnt--;
            }
            stack.push(c);
            if (cnt == 0 && !stack.isEmpty()) {
                char[] chars = new char[stack.size()];
                for (int i = stack.size() - 1; i >= 0; i--) {
                    chars[i] = stack.pop();
                }
                list.add(chars);
            }



        }

        StringBuilder sb = new StringBuilder();
        if (!list.isEmpty()) {
            for (char[] chars : list) {
                chars[0] = ' ';
                chars[chars.length - 1] = ' ';
                sb.append(new String(chars));
            }
        }
        String replace = sb.toString().replace(" ", "");
        return sb.toString().replace(" ", "");
    }
}

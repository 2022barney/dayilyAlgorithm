package org.calm.august;

import java.util.*;
import java.util.regex.Pattern;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/7
 * @version: v1.0
 * ---------------------------
 */
public class Day0807 {
    public static void main(String[] args) {

        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("1:start:6");
        logs.add("1:end:6");
        logs.add("0:end:7");
        exclusiveTime(2, logs);
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<String> stack = new Stack<>();
        int[] dict = new int[n];
        int individual = 0;
        for (int i = 0; i < logs.size(); i++) {
            String cur = logs.get(i);
            if (stack.isEmpty()) {
                stack.push(logs.get(i));
            } else {
                if (cur.contains("end")) {
                    String pre = stack.pop();
                    String[] info = splitStr(pre);
                    int id = Integer.parseInt(info[0]);
                    int start = Integer.parseInt(info[2]);
                    int end = Integer.parseInt(splitStr(cur)[2]);
                    dict[id] += end - start + 1 - individual;
                    if (!stack.isEmpty()) {
                        individual = end - start + 1;
                    }
                } else {
                    stack.push(logs.get(i));
                }
            }
        }
        return dict;

    }

    static String[] splitStr(String str) {
        String[] res = str.split(":");
        return res;
    }
}

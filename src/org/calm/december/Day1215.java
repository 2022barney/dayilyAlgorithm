package org.calm.december;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ------------------------
 *394. medium.  字符串解码
 * ------------------------
 * @author liyang
 * @date 2022/12/15
 * @version 1.0
 * ------------------------

 */
public class Day1215 {

    public static void main(String[] args) {
        //String s = decodeString("3[a]2[bc]");
        //String s = decodeString2("3[a2[c]]");
        String s = decodeString2("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(s);
    }
    // 国际站做法
    public static String decodeString(String s) {
        Deque<Character> q = new LinkedList<>();

        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c != ']') {
                q.addLast(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (Character.isLetter(q.peekLast())) {
                    sb.insert(0, q.pollLast());
                }
                q.pollLast(); // 去除 '['
                StringBuilder d = new StringBuilder();
                while (!q.isEmpty() && Character.isDigit(q.peekLast())) {
                    d.insert(0, q.pollLast());
                }
                int cnt = Integer.parseInt(d.toString());
                while (cnt-- > 0) {
                    for (char x : sb.toString().toCharArray()) {
                        q.addLast(x);
                    }
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!q.isEmpty()) {
            ans.insert(0, q.pollLast());
        }
        return ans.toString();

    }
    // 两个stack
    public static String decodeString2(String s) {
        Deque<StringBuilder> resQ = new LinkedList<>();
        Deque<Integer> kQ = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                kQ.addLast(k);
                k = 0;
                resQ.addLast(res);
                res = new StringBuilder();
            } else if (c == ']') {
                Integer cnt = kQ.pollLast();
                StringBuilder tmp = new StringBuilder();
                while (cnt-- > 0) {
                    tmp.append(res);
                }
                res = resQ.pollLast().append(tmp);
            } else if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

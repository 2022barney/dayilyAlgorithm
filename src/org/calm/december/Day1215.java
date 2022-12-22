package org.calm.december;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ------------------------
 * <p>
 * ------------------------
 *
 * @author liyang
 * @version 1.0
 * ------------------------
 * @date 2022/12/15
 */
public class Day1215 {

    public static void main(String[] args) {
        String s = decodeString("3[a]2[bc]");
        System.out.println(s);
    }

    public static String decodeString(String s) {
        Deque<String[]> q = new LinkedList<>();
        int num = 0;
        int n = s.length();
        String cur = "";
        String pre = "";
        for (int i = 0; i < n; ) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < n && Character.isDigit(s.charAt(j))) j++;
                num = Integer.parseInt(s.substring(i, j));
                i = j;
                q.offer(new String[]{"00", String.valueOf(num)});
            } else if (c == '[') {
                i++;
            } else if (c == ']') {
                while (!q.isEmpty()) {
                    String[] str = q.pollLast();
                    if (str[0].equals("00")) {
                        cur = cur.repeat(Integer.parseInt(str[1]));
                        pre = pre + cur;
                        System.out.println(pre);
                    } else {
                        cur = str[1] + cur;
                    }
                }
                i++;
            } else {
                int j = i;
                while (j < n && s.charAt(j) >= 'a' && s.charAt(j) <= 'z') j++;

                String zz = s.substring(i, j);
                q.addLast(new String[]{"01", zz});
                i = j;
            }
        }


        return pre;

    }
}

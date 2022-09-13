package org.calm.august;

/**
 * ---------------------------
 * 899. hard
 * ---------------------------
 * @author: liyang
 * @date: 2022/8/3
 * @version: v1.0
 * ---------------------------
 */
public class Day0803 {
    public static void main(String[] args) {
        orderlyQueue("tk", 1);

    }

    public static String orderlyQueue(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        String ans = s;
        if (k == 1) {

            for (int i = 0; i < s.length(); i++) {
                String t = s.substring(i) + s.substring(0, i);
                System.out.println(t);
                if (t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
            return ans;
        } else {
            int[] dict = new int[26];
            for (char c : s.toCharArray()) {
                dict[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (dict[i] != 0) {
                    String t = (char)(i + 'a') + "";
                    sb.append(t.repeat(dict[i]));
                }
            }
            return sb.toString();
        }
    }
}

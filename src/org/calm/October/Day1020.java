package org.calm.October;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/10/20
 * @version 1.0
 * ------------------------
 */
public class Day1020 {
    String str = "0";
    public int kthGrammar(int n, int k) {

        int a = 1;
        while (a < n) {
            recursive();
            a++;
        }
        return Integer.parseInt(str.charAt(k - 1) + "");
    }

    void recursive() {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        str = sb.toString();
    }

}

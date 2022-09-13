package org.calm.august;

import java.util.HashMap;
import java.util.Map;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/8/5
 * @version: v1.0
 * ---------------------------
 */
public class AddString {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {

        }
        addStrings("11", "123");
    }
    public static String addStrings(String num1, String num2) {

        int l1 = num1.length(), l2 = num2.length();
        int i = l1 - 1, j = l2 - 1, cur = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int a = 0;
            if (i >= 0) {
                a = num1.charAt(i) - '0';
            }
            int b = 0;
            if (j >= 0) {
                b = num2.charAt(j) - '0';
            }
            cur = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.append(cur);
            i--;
            j--;
        }
        if (carry > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

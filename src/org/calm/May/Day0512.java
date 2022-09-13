package org.calm.May;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/5/12
 * @version: v1.0
 * ---------------------------
 */
public class Day0512 {

    public static void main(String[] args) {
        String[] strs = new String[]{"cba","daf","ghi"};
        int i = minDeletionSize(strs);
        System.out.println(i);
    }

    public static int minDeletionSize(String[] strs) {
        int res = 0;
        int len = strs.length;
        int strLen = strs[0].length();


        if (len == 1) {
            return res;
        }
        char[] record = strs[0].toCharArray();
        for (char c : record) {
            System.out.println(c);
        }
        for (int i = 1; i < len; i++) {
            String cur = strs[i];
            for (int j = 0; j < strLen; j++) {
                if (record[j] == 'A') {
                    continue;
                }
                int subVar = cur.charAt(j) - record[j];
                if (subVar < 0) {
                    record[j] = 'A';
                    res++;

                } else {
                    record[j] =  cur.charAt(j);
                }
            }
        }
        return res;
    }
}

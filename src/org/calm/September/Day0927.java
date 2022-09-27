package org.calm.September;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/9/27
 * @version 1.0
 * ------------------------
 */
public class Day0927 {

    public boolean CheckPermutation(String s1, String s2) {
        int[] dict = new int[26];
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            dict[s1.charAt(i) - 'a']++;
            dict[s2.charAt(i) - 'a']--;
        }
        for (int num : dict) {
            if (num != 0) return false;
        }
        return true;
    }
}

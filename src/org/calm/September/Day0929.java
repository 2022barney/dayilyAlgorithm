package org.calm.September;
/**
 * ------------------------
 *
 * ------------------------
 * @author liyang
 * @date 2022/9/29
 * @version 1.0
 * ------------------------
 */
public class Day0929 {

    public boolean isFlipedString(String s1, String s2) {

        return s1.length() == s2.length() && (s2 + s2).indexOf(s1) > 0;

    }
}

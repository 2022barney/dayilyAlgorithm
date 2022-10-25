package org.calm.October;

import java.util.List;

/**
 * ------------------------
 * 28、kmp
 * ------------------------
 * @author liyang
 * @date 2022/10/25
 * @version 1.0
 * ------------------------
 */
public class Day1025_1 {
    public int strStr(String haystack, String needle) {
        // 1. 朴素搜索
        /*int m = haystack.length(), n = needle.length();
        char[] hs = haystack.toCharArray();
        char[] ns = needle.toCharArray();
        for (int i = 0; i <= m - n; i++) {
            int a = i, b = 0;
            while (b < n && hs[a] == ns[b]) {
                a++;
                b++;
            }
            if (b == n) return i;
        }
        return -1;*/
        // 2. kmp
        if (needle.isEmpty()) return 0;
        // 分别读取原串和匹配串的长度
        int n = haystack.length(), m = needle.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        haystack = " " + haystack;
        needle = " " + needle;

        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }
        return -1;
    }
}

class Trie {
    class TrieNode {
        boolean end;
        TrieNode[] ts = new TrieNode[26];
    }

    TrieNode p;

    public Trie() {
        p = new TrieNode();
    }

    public void insert(String str) {
        int n = str.length();
        TrieNode tn = p;
        for (int i = 0; i < n; i++) {
            int x = str.charAt(i) - 'a';
            if (tn.ts[x] == null) {
                tn.ts[x] = new TrieNode();
            }
            tn = tn.ts[x];
        }
        tn.end = true;
    }

    public boolean startWith(String str) {
        TrieNode tn = p;
        for (int i = 0; i < str.length(); i++) {
            int x = str.charAt(i) - 'a';
            if (tn.ts[x] == null) {
                return false;
            }
            tn = tn.ts[x];
        }
        return true;
    }
}

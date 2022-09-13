package org.calm.july;

import java.util.List;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/7
 * @version: v1.0
 * ---------------------------
 */
public class Day0707 {

    public static void main(String[] args) {
        String str = "1";
        String substring = str.substring(0, 1);
        System.out.println(substring);
    }

    // a ab
    // abcd aa  abc bc
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String str : dictionary) {
           trie.insert(str);
        }
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
           for (int i = 0; i < s.length(); i++) {
               String subStr = s.substring(0, i + 1);
               if (trie.search(subStr)) {
                   sb.append(subStr).append(" ");
                   break;
               }
           }
        }
        return sb.toString().trim();
    }

}

class Trie {
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
               p.tns[u] = new TrieNode();
            }
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return p.end;
    }
}
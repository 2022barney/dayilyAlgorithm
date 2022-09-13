package org.calm.july;

/**
 * ---------------------------
 * 745.hard 字典树
 * ---------------------------
 * @author: liyang
 * @date: 2022/7/14
 * @version: v1.0
 * ---------------------------
 */
public class Day0714 {

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"c", "i", "c", "i"});
        int f = wordFilter.f("i", "c");
        System.out.println(f);
    }
}

class WordFilter {
    NewTrie trie;
    public WordFilter(String[] words) {
        trie = new NewTrie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
    }

    public int f(String pref, String suff) {

        String t = pref + "{" + suff;
        NewTrie.TrieNode node = trie.search(t);
        if (node == null) {
            return -1;
        } else {
            return node.weight;
        }

    }
}
class NewTrie {

    class TrieNode {
        boolean isEnd;
        TrieNode[] tns = new TrieNode[27];
        int weight;
    }

    TrieNode root;

    public NewTrie() {
        root = new TrieNode();
    }

    /**
     * ["WordFilter","f"]
     * [[["abbba","abba"]],["ab","ba"]]
     * @param s
     * @param idx
     */
    public void insert(String s, int idx) {

        for (int i = 0; i <= s.length(); i++) {
            String str = s.substring(s.length() - i, s.length()) + "{" + s;
            System.out.println(str);
            TrieNode p = root;
            for (int j = 0; j < str.length(); j++) {
                int u = str.charAt(j) - 'a';
                if (p.tns[u] == null) {
                    p.tns[u] = new TrieNode();
                }
                p.tns[u].weight = idx;
                p = p.tns[u];
            }
            p.isEnd = true;
        }
    }


    public TrieNode search(String s) {
        System.out.println(s);
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return null;
            }
            p = p.tns[u];
        }
        return p;
    }
}


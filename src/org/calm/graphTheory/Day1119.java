package org.calm.graphTheory;

import java.util.*;

/**
 * ------------------------
 * 127.hard 单词接龙
 * ------------------------
 *
 * @author liyang
 * @version 1.0
 * ------------------------
 * @date 2022/11/19
 */
public class Day1119 {


    Set<String> set;

    /**
     * 双向bfs
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q1 = new ArrayDeque<>();
        Queue<String> q2 = new ArrayDeque<>();

        Map<String, Integer> m1 = new HashMap<>();
        Map<String, Integer> m2 = new HashMap<>();


        q1.offer(beginWord);
        m1.put(beginWord, 0);
        q2.offer(endWord);
        m2.put(endWord, 0);

        int ans = -1;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            ans = -1;
            if (q1.size() < q2.size()) {
                ans = update(q1, m1, m2);
            } else {
                ans = update(q2, m2, m1);
            }
            if (ans != -1) return ans;
        }

        return ans == -1 ? 0 : ans + 1;
    }

    int update(Queue<String> queue, Map<String, Integer> cur, Map<String, Integer> other) {
        String model = "abcdefghijklmnopqrstuvwxyz";
        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (int j = 0; j < word.length(); j++) {
                for (int k = 0; k < 26; k++) {
                    StringBuilder sb = new StringBuilder(word);
                    if (sb.charAt(j) != model.charAt(k)) {
                        sb.setCharAt(j, model.charAt(k));
                        if (set.contains(sb.toString())) {
                            if (cur.containsKey(sb.toString()) && cur.get(sb.toString()) <= cur.get(word) + 1) {
                                continue;
                            } else if (other.containsKey(sb.toString())) {
                                return cur.get(word) + 1 + other.get(sb.toString());
                            } else {
                                queue.offer(sb.toString());
                                cur.put(sb.toString(), cur.get(word) + 1);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}

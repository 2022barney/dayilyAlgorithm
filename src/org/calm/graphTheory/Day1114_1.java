package org.calm.graphTheory;

import java.util.*;

/**
 * ------------------------
 * 752.medium
 * ------------------------
 * @author liyang
 * @date 2022/11/14
 * @version 1.0
 * ------------------------
 */
public class Day1114_1 {

    //时间复杂度：O(b^d * d^2 + md)
    // ，其中 b 是数字的进制，d 是转盘数字的位数，m 是数组 deadends 的长度，在本题中
    // b=10 d=4d
    //空间复杂度：O(b^d * d + m)


    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        List<String> dead = Arrays.asList(deadends);
        if (dead.contains(target) || dead.contains("0000")) {
            return -1;
        }
        String model = "0123456789";
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        queue.offer("0000");
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String curNum = queue.poll();
                for (String next : get(curNum)) {
                    if (!visited.contains(next) && !dead.contains(next)) {
                        if (next.equals(target)) {
                            return dist;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    List<String> get(String str) {
        List<String> res = new ArrayList<>();
        char[] cs = str.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = cs[i];
            cs[i] = getPre(num);
            res.add(new String(cs));
            cs[i] = getNext(num);
            res.add(new String(cs));
            cs[i] = num;
        }
        return res;
    }

    char getPre(char c) {
        return c == '0' ? '1' :(char)(c - 1);
    }

    char getNext(char c) {
        return c == '9' ? '0' :(char)(c + 1);
    }
}

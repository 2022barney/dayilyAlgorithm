package org.calm.june;

import java.util.*;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/19
 * @version: v1.0
 * ---------------------------
 */
public class Test191 {
    public static void main(String[] args) {
        Map<Integer, Object> map = new HashMap<>();
        Integer orDefault = (Integer) map.getOrDefault(1, 0);
        for (Map.Entry<Integer, Object> integerObjectEntry : map.entrySet()) {
            integerObjectEntry.getValue();
            integerObjectEntry.getKey();
        }
        List<Integer> list = new ArrayList<>();
        for (long i = 0; i < list.stream().count(); i++) {
            
        }
    }
}

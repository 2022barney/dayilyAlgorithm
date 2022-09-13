package org.calm.june;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/6/11
 * @version: v1.0
 * ---------------------------
 */
public class Test {
    public static void main(String[] args) {
        Date date = new Date("1655790790000");
        String str = "123456";
        str.replace("a", "b);");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println((11 + 12 - 1) / 12);
        System.out.println(11 / 12);
    }


    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        TreeMap<Long, Integer> map = new TreeMap<>(Map.of(Long.MAX_VALUE, potions.length));
        for (int i = potions.length - 1; i >= 0; i--) {
            map.put((long) potions[i], i);
        }
        for (int i = 0; i < spells.length; i++) {
            spells[i] = potions.length - map.ceilingEntry((success + spells[i] - 1) / spells[i]).getValue();
        }
        return spells;
    }
}

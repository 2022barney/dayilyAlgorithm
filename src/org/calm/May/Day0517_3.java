package org.calm.May;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * ---------------------------
 *
 * ---------------------------
 * @author: liyang
 * @date: 2022/5/17
 * @version: v1.0
 * ---------------------------
 */
public class Day0517_3 {
    public static void main(String[] args) {
        int[] a = new int[]{10, 5, 3, 1};
        int left = 0;
        int right = 3;
        for (int i = left, j = i; i < right; j = ++i) {
            int ai = a[i + 1];
            while (ai < a[j]) {
                a[j + 1] = a[j];
                if (j-- == left) {
                    break;
                }
            }
            a[j + 1] = ai;
        }
        for (int i : a) {
            System.out.println(i);
        }
    }


    public static Object getByAttributeName(Object object,String attributeName) {
        try {
            // public属性用getField即可
            Field field = object.getClass().getDeclaredField(attributeName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

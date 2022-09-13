package org.calm.September;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 * @author: liyang
 * @date: 2022/9/2
 * @version: v1.0
 * ---------------------------
 */
public class Stream {
    public static void main(String[] args) {
        // iterate
        java.util.stream.Stream.iterate(10, n -> n + 1).limit(10).forEach(System.out::println);
        // generate
        java.util.stream.Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

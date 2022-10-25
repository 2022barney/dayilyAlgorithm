package org.calm.October;
/**
 * ------------------------
 * 779. medium
 * ------------------------
 * @author liyang
 * @date 2022/10/20
 * @version 1.0
 * ------------------------
 */
public class Day1020 {
    int kthGrammar(int n, int k) {
        if (k == 1) return 0; // 向上遍历到了第1行，则返回结果
        if (k > (1 << n - 2)) return 1 ^ kthGrammar(n - 1, k - (1 << n - 2)); // 如果在“蓝色区间”，则与上一行值相反
        else return kthGrammar(n - 1, k); // 如果在“黄色区间”，则与上一行值相同
    }

}

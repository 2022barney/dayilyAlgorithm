package org.calm.binarySearch;

/**
 * ---------------------------
 *
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/7/14
 * @version: v1.0
 * ---------------------------
 */
public class ConstructArr {
    public static void main(String[] args) {

        //int i = maxValue(6, 0, 27);
        //System.out.println(i);


        System.out.printf("%x", Integer.MAX_VALUE);
    }




    public static int maxValue(int n, int index, int maxSum) {

        int rest = maxSum - n;
        int l = 0, r = maxSum;
        while (l + 1 != r) {
            int m = l + r >> 1;
            int count = m * m;
            // if(m>index) count -= (m-index-1)*(m-index)/2;
            //            //如果右边越界，就减去右边多的
            //            if(m>(n-index)) count -= (m-(n-index-1)-1)*(m-(n-index-1))/2;
            //
            //作者：shaogezhu
            //链接：https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/solution/-by-shaogezhu-tfs1/
            //来源：力扣（LeetCode）
            //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
            if (m - 1 > index) {
                count -= (m - index) * (m - index - 1) / 2;
            }
            if (m > (n - index)) {
                count -= (m - (n - index )) * (m - (n - index) + 1) / 2;
            }
            if (count <= rest) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;

    }

}

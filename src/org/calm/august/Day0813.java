package org.calm.august;

/**
 * ---------------------------
 * <p>
 * ---------------------------
 *
 * @author: liyang
 * @date: 2022/8/13
 * @version: v1.0
 * ---------------------------
 */
public class Day0813 {
    public static void main(String[] args) {
        int theWinner = findTheWinner(5, 2);
        System.out.println(theWinner);
    }

    public static int findTheWinner(int n, int k) {

        ListNode head = new ListNode();
        head.val = 1;
        ListNode tmp = head;
        for (int i = 2; i <= n; i++) {
            ListNode next = new ListNode();
            next.val = i;
            tmp.next = next;
            next.pre = tmp;
            tmp = tmp.next;
        }

        tmp.next = head;
        head.pre = tmp;

        ListNode tt = head;
        while (tt.next != tt) {
            int i = 1;
            while(i < k) {
                tt = tt.next;
                i++;
            }
            if (tt.pre == tt && tt.next == tt) break;
            ListNode pre = tt.pre;
            ListNode ne = tt.next;
            pre.next = ne;
            ne.pre = pre;
            tt = ne;
        }
        return tt.val;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode pre;
}
package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 * Created by zhanghr on 2017/3/7.
 */
public class Code24 {

    /**
     * 55 / 55 test cases passed.
     * Status: Accepted
     * Runtime: 6 ms
     * Beats 12.74%
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        int  temp;
        ListNode pre, cur =head, root = head;
        while (cur.next != null){
            pre = cur;
            cur = cur.next;
            temp = cur.val;
            cur.val = pre.val;
            pre.val = temp;
            if (cur.next == null)
                break;
            else
                cur = cur.next;
        }
        return root;

    }
}

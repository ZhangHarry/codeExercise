package Algorithm.ProgrammerInterview;

import Algorithm.leetcode.util.ListNode;

/**
 * Created by zhanghr on 2018/7/19.
 */

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        ListNode head = pHead;
        ListNode cur = new ListNode(pHead.val);
        pHead = pHead.next;
        while (pHead != null){
            ListNode tmp = new ListNode(pHead.val);
            tmp.next = cur;
            cur = tmp;
            pHead =pHead.next;
        }
        while (head != null){
            if (head.val != cur.val)
                return false;
            head = head.next;
            cur = cur.next;
        }
        return true;
    }
}

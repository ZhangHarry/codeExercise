package Algorithm.ProgrammerInterview;

import Algorithm.leetcode.util.ListNode;

/**
 * Created by zhanghr on 2018/7/24.
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前

 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */

public class Partition {

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode small=null, big = null;
        ListNode s=null,b=null;
        while (pHead!=null){
            if (pHead.val < x){
                if (small == null){
                    small = pHead;
                    s = small;
                }
                else{
                    small.next = pHead;
                    small = pHead;
                }
                pHead = pHead.next;
                small.next = null;
            }else{
                if (big == null){
                    big = pHead;
                    b = big;
                }
                else{
                    big.next = pHead;
                    big = pHead;
                }
                pHead = pHead.next;
                big.next = null;
            }
        }
        if (s == null)
            return b;
        small.next = b;
        return s;
    }
}

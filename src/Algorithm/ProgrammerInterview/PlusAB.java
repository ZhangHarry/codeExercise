package Algorithm.ProgrammerInterview;


import Algorithm.leetcode.util.ListNode;

/**
 * Created by zhanghr on 2018/7/19.

 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。

 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。

 测试样例：
 {1,2,3},{3,2,1}
 返回：{4,4,4}

 */

public class PlusAB {
    // 注意遍历完成后，如果还有进位的情况
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNode head = new ListNode((a.val+b.val)%10);
        ListNode cur = head;
        int plus = (a.val+b.val)/10;
        a = a.next;
        b = b.next;
        while (a != null && b!=null){
            int av = a.val;
            int bv = b.val;
            ListNode tmp = new ListNode((av+bv+plus)%10);
            plus = (av+bv+plus)/10;
            cur.next = tmp;
            cur = tmp;
            a = a.next;
            b = b.next;
        }
        if (plus == 0){
            if (a == null)
                cur.next = b;
            else
                cur.next = a;
        }else{
            ListNode next = a == null ? b : a;
            while (next != null && plus > 0){
                ListNode tmp = new ListNode((next.val+plus)%10);
                plus = (next.val+plus)/10;
                cur.next = tmp;
                cur = tmp;
                next = next.next;
            }
            if (plus > 0)
                cur.next = new ListNode(plus);
        }
        return head;
    }
}

package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.ListNode;

/**
 * Created by zhanghr on 2018/7/13.
 Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example 1:

 Input: 1->2->3->4->5->NULL
 Output: 1->3->5->2->4->NULL
 Example 2:

 Input: 2->1->3->5->6->4->7->NULL
 Output: 2->3->6->7->1->5->4->NULL
 Note:

 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...


 */

public class OddEvenLinkedList {
    // beat 43.86%
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode oddH = odd;
        ListNode even = head.next;
        ListNode evenH = even;
        head = even.next;
        odd.next = null;
        even.next = null;
        while (head != null){
            // 移动odd指针
            odd.next = head;
            odd = head;
            if (head.next !=null){
                head = head.next;//移动head指针
                odd.next = null;//断开odd指针与原链表的关联
                even.next = head;//移动even指针
                even = head;
                head = head.next;//移动head指针
                even.next = null;//断开even指针与原链表的关联
            }else
                break;

        }
        odd.next = evenH;
        return oddH;
    }
}

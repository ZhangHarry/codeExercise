package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/9/6.
 Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.
 */
import Algorithm.leetcode.util.ListNode;

public class RemoveNthNodeFromEndofList {

    // beat 99%
    // 需要注意边界条件，注意题目保证了n是有效的，所以需要注意的边界就是需要将head移除的情况---代码里返回的都是head。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode after=head;
        ListNode before = head;
        int i=0;
        while (i<n && before != null){
            before = before.next;
            i++;
        }
        if (before == null)
            return head.next;
        while (before.next != null){
            before = before.next;
            after = after.next;
        }
        after.next = after.next.next;
        return head;
    }
}

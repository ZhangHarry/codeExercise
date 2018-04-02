package Algorithm.aimAtOffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author zhanghr
 *
 */
public class FindKthToTail {
	public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null)
            return null;
        ListNode slow= head, fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
            if (fast == null && k > 0)
                return null;
        }        
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

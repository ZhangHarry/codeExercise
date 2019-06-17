package Algorithm.leetcode.finished;
import Algorithm.leetcode.util.ListNode;
/**
 * Created by zhanghr on 2018/9/18.
 */

public class RevreseKGroup {
    public static ListNode reverse(ListNode node){
        ListNode cur = node;
        ListNode next = node.next;
        cur.next = null;
        while (next != null){
            ListNode tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        return cur;
    }

    public static ListNode reverse(ListNode node, int k){
        if (k==1)
            return node;
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode cur = head;
        ListNode end = head;
        int count = 0;
        while(end != null){
            count++;
            end = end.next;
            if (count == k && end != null){
                ListNode start = cur.next;
                ListNode h = start;
                ListNode next = start.next;
                while (next != end){
                    ListNode tmp = next.next;
                    next.next = start;
                    start = next;
                    next = tmp;
                }
                h.next = end.next;
                end.next = start;
                cur.next = end;
                cur = h;
                end = h;
                count = 0;
            }
        }
        return head.next;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
        System.out.println(n1);
        ListNode node = reverse(n1,  3);
        System.out.println(node);
    }
}

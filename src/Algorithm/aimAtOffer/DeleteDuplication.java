package Algorithm.aimAtOffer;

/**
 * 该题的注意事项有两点：对于node求出第一个不同next；需要保证node自身时不同的，简单起见人工创造一个头部，把头部设为node，再开始
 * Created by zhanghr on 2018/5/26.
 */

public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode temp  = new ListNode(0);
        temp.next = pHead;

        ListNode node = temp;
        while (node !=null){
            ListNode next = node.next;
            if (next == null || next.next == null || next.val != next.next.val)
                node = next;
            else {
                next = getNext(next);
                node.next = next;
            }
        }
        return temp.next;
    }

    public ListNode getNext(ListNode node){
        ListNode r = node;
        while (r.next != null && r.val == r.next.val)
            r = r.next;
        return r.next;
    }
}

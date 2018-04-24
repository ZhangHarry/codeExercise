package Algorithm.aimAtOffer;

import java.util.HashMap;

/**
 * Note : list may contain ring
 * Created by zhanghr on 2018/4/24.
 */

public class ListClone {
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        if (map.get(pHead) != null)
            return map.get(pHead);
        RandomListNode h = new RandomListNode(pHead.label);
        map.put(pHead, h);
        h.random = Clone(pHead.random);
        h.next = Clone(pHead.next);
        return h;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
package Algorithm.leetcode.finished;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		ListNode node = this;
		while(node != null){
			sBuffer.append(node.val+",");
			node = node.next;			
		}
		return sBuffer.toString();
	}
}
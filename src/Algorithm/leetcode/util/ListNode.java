package Algorithm.leetcode.util;

public class ListNode {
	public int val;
    public ListNode next;
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
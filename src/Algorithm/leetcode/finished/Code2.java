package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * Runtime: 53 ms	61.16%
 * 
 * @author zhanghr
 *
 */
public class Code2 {
	
	public static void main(String[] args) {
		int[] l1 = new int[]{2,4,3};
		int[] l2 = new int[]{5,6,4};
		ListNode node1 = Code2.construct(l1);
		ListNode node2 = Code2.construct(l2);
		System.out.println(node1);
		System.out.println(node2);
		ListNode node = new Code2().addTwoNumbers(node1, node2);
		System.out.println(node);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result = l1.val+l2.val;
        int input = result/10;
        ListNode node = new ListNode(result%10);
        ListNode cur = node;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null&& l2 != null) {
			result = l1.val+l2.val+input;
			input = result/10;
			ListNode newNode = new ListNode(result%10);
			cur.next = newNode;
			cur = newNode;
			l1 = l1.next;
			l2 = l2.next;
		}

        while (l1 != null) {
        	if (input == 0) {
				cur.next = l1;
				break;
			}else {
				result = l1.val+input;
				input = result/10;
				ListNode newNode = new ListNode(result%10);
				cur.next = newNode;
				cur = newNode;
				l1 = l1.next;
			}
		}
        
        while (l2 != null) {
        	if (input == 0) {
				cur.next = l2;
				break;
			}else {
				result = l2.val+input;
				input = result/10;
				ListNode newNode = new ListNode(result%10);
				cur.next = newNode;
				cur = newNode;
				l2 = l2.next;
			}
		}
        
        if (input> 0) {
			cur.next = new ListNode(input);
		}
        return node;
    }
	
	
	public static ListNode construct(int[] list) {
		ListNode node = new ListNode(list[0]);
		ListNode cur = node;
		for (int i = 1; i < list.length; i++) {
			ListNode next = new ListNode(list[i]);
			cur.next = next;
			cur = next;
		}
		return node;
	}
}


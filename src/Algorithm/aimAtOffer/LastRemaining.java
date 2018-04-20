package Algorithm.aimAtOffer;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,
 * 让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“
 * 名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 
 * @author zhanghr
 *
 */
public class LastRemaining {
	public int LastRemaining_Solution(int n, int m) {
		Node node = new Node(0);
		Node head = node;
		for (int i = 1; i < n; i++) {
			Node no = new Node(i);
			node.next = no;
			no.pre = node;
			node = no;
		}
		node.next = head;
		head.pre = node;
		while (head != head.next) {
			for (int i = 0; i < m - 1; i++) {
				head = head.next;
			}
			System.out.print(head.val + ",");
			Node temp = head.pre;
			temp.next = head.next;
			head.next.pre = temp;
			head = temp.next;
		}
		System.out.println(head.val);
		return head.val;
	}

	public static void main(String[] args) {
		LastRemaining test = new LastRemaining();
		test.LastRemaining_Solution(5, 1);
		test.LastRemaining_Solution(5, 2);
		test.LastRemaining_Solution(5, 3);
	}
}

class Node {
	int val;
	Node next;
	Node pre;

	Node(int v) {
		this.val = v;
	}
}
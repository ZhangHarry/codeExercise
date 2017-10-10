package Algorithm.leetcode.finished;

import java.util.HashSet;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * Example:
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 * 
 * beat 94.29%, 4ms
 *
 * Created by zhanghr on 2016/12/15.
 */
public class Code316_2 {
	 public String removeDuplicateLetters(String s) {
	    	int[] counter = new int[26];
	    	for (int i = 0; i < s.length(); i++) {
	    		char c = s.charAt(i);
				counter[c-'a']++;
			}
	    	ListNode list = null;
	    	boolean[] set = new boolean[26]; // HashSet<Character> set = new HashSet<>();

	    	for (int i = 0; i < s.length(); i++) {
	    		char c = s.charAt(i);
				if (set[c-'a']) {
					counter[c-'a']--;
					continue;
				}

				char cur;
				while (list !=null && (cur=list.val) >=c && counter[cur-'a']>0) {
					list = list.next;
					set[cur-'a'] = false;
				}
				ListNode node = new ListNode(c);
				node.next = list;
				list = node;
				set[c-'a'] = true;
				counter[c-'a']--;
			}
	    	String sBuffer = "";
	    	while (list != null) {
				sBuffer = list.val+sBuffer;
				list = list.next;
			}
	        return sBuffer;
	    }

	    class ListNode {
	        char val;
	        ListNode next;
	        ListNode(char x) { val = x; }
	    }

    public static void main(String[] args){
        String s , result, expect;
        Code316_2 obj = new Code316_2();
        s = "bcabc";
        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("abc")));
        s = "cbacdcbc";
        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("acdb")));
        s = "bddbccd";
        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("bcd")));
        s = "cbaddabaa";
        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("cadb")));
        s = "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws";
        expect = "bfegkuyjorndiqszpcaw";
        System.out.println((result=obj.removeDuplicateLetters(s)) + "-----" +(result.equals(expect))+ "-----"+expect);
        s = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
        expect = "chzafipuegjlxdqnbsotwrym";
        System.out.println((result=obj.removeDuplicateLetters(s)) + "-----"+(result.equals(expect))+ "-----"+expect);
        s = "wmxkuuoordmnpnebikzzujdpscpedcrsjphcaykjsmobturjjxxpoxvvrynmapegvtlasmyuddgxygkaztmbpkrnukbxityz";
        expect = "wbcdhajmoegvlskprnuxityz";
        System.out.println((result=obj.removeDuplicateLetters(s)) + "-----"+(result.equals(expect))+ "-----"+expect);
    }
}

package Algorithm.leetcode.finished;

import java.util.*;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * Example:
 * Given "bcabc"
 * Return "abc"
 * Given "cbacdcbc"
 * Return "acdb"
 *
 * beat 55.04% , 18ms
 * Created by zhanghr on 2016/12/15.
 */
public class Code316 {
    public String removeDuplicateLetters(String s) {
    	int[] counter = new int[26];
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
			counter[c-'a']++;
		}
    	List<Character> list = new LinkedList<Character>();
    	HashSet<Character> set = new HashSet<>();

    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
			if (set.contains(c)) {
				counter[c-'a']--;
				continue;
			}
			int length = 0;
			char cur;
			while ((length = list.size())>0 && (cur=list.get(length-1)) >=c && counter[cur-'a']>0) {
				list.remove(length-1);
				set.remove(cur);
			}
			list.add(length, c);
			set.add(c);
			counter[c-'a']--;
		}
    	
    	StringBuffer sBuffer= new StringBuffer();
    	for (int i = 0; i < list.size(); i++) {
			sBuffer.append(list.get(i));
		}
        return sBuffer.toString();
    }


    public static void main(String[] args){
        String s , result;
        Code316 obj = new Code316();
//        s = "bcabc";
//        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("abc")));
        s = "cbacdcbc";
        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("acdb")));
        s = "bddbccd";
        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("bcd")));
        s = "cbaddabaa";
        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("cadb")));
        s = "rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws";
        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("bfegkuyjorndiqszpcaw")));
        s = "beeaddbeb";
        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("adbe")));
        s = "eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm";
        System.out.println(s+" "+(result=obj.removeDuplicateLetters(s)) + " "+(result.equals("chzafipuegjlxdqnbsotwrym")));
        s = "wmxkuuoordmnpnebikzzujdpscpedcrsjphcaykjsmobturjjxxpoxvvrynmapegvtlasmyuddgxygkaztmbpkrnukbxityz";
        System.out.println((result=obj.removeDuplicateLetters(s)) + " "+(result.equals("wbcdhajmoegvlskprnuxityz")));
    }

}

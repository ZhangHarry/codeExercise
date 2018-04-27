package Algorithm.leetcode.finished;

import java.util.Arrays;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
        int[] lowArray = new int[26];
        int[] upperArray = new int[26];
        if (s==null || s.length() == 0 )
            return 0;
        for (int i =0; i <s.length(); i++){
            char ch = s.charAt(i);
            if (ch-'a' < 26 && ch-'a' >= 0)
                lowArray[ch-'a']++;
            else 
                upperArray[ch-'A']++;
        }
        int count = 0;
        int maxOdd = 0;
        for (int i=0;i<26;i++){
            if (lowArray[i]%2 == 0)
                count += lowArray[i];
            else{
                maxOdd = Math.max(maxOdd,lowArray[i]);
            }
            
            if (upperArray[i]%2 == 0)
                count += upperArray[i];
            else{
            	maxOdd = Math.max(maxOdd,upperArray[i]);
            }
        }
        return count+maxOdd;
    }
	
	public static void main(String[] args) {
		LongestPalindrome test = new LongestPalindrome();
		test.longestPalindrome("aBccccAA");
	}
}

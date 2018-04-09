package Algorithm.leetcode.finished.backTracking;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author zhanghr
 *
 */
import java.util.*;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String string = "aa";
		PalindromePartitioning test = new PalindromePartitioning();
		test.partition(string);
				
	}
	
	// beat 66.93%
	public List<List<String>> partition(String s) {
		List<List<String>> result = new LinkedList<>();
		if (s == null || s.length() == 0)
			return result;
		backTrack(result, new LinkedList<String>(), s, 0, s.length());
		return result;
	}

	private void backTrack(List<List<String>> result, LinkedList<String> list, String s, int i, int j) {
		if (i == j) {
			result.add(new LinkedList<>(list));
			return;
		}
		
		for (int index = i; index < j; index++) {
			if (isPalindrome(s, i, index)) {
				list.add(s.substring(i, index+1));
				backTrack(result, list, s, index+1, j);
				list.removeLast();
			}
		}
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i<=j){
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}

package Algorithm.leetcode.finished.backTracking;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * @author zhanghr
 *
 */
public class LetterCombination {
	String[] chars = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> list = new LinkedList<String>();
		if (digits == null || digits.length() == 0)
			return list;
		letterCombinations(digits, list, 0, "");
		return list;
	}

	public void letterCombinations(String digits, List<String> list, int index, String before) {
		if (index == digits.length()) {
			list.add(before);
		} else {
			String choice = chars[digits.charAt(index)-'0'];
			int length = choice.length();
			if (length > 0) {
				for (int i = 0; i < length; i++) {
					letterCombinations(digits, list, index + 1, before + choice.charAt(i));
				}
			}else 
				letterCombinations(digits, list, index + 1, before);
		}
	}

	public static void main(String[] args) {
		LetterCombination test = new LetterCombination();
		List<String> list = test.letterCombinations("123");
		for (String string : list){
			System.out.println(string);
		}
	}
}

package Algorithm.lintcode.dp;

import java.util.*;

/**
 * Give a dictionary of words and a sentence with all whitespace removed, return
 * the number of sentences you can form by inserting whitespaces to the sentence
 * so that each word can be found in the dictionary.
 * 
 * Example Given a String CatMat Given a dictionary ["Cat", "Mat", "Ca", "tM",
 * "at", "C", "Dog", "og", "Do"] return 3
 * 
 * we can form 3 sentences, as follows: CatMat = Cat Mat CatMat = Ca tM at
 * CatMat = C at Mat
 * 
 * @author zhanghr
 *
 */

public class WordBreakIII {
	/*
	 * beat 18.18%，lintcode的test case貌似有问题，test case没有区分大小写，所以加了一段更新dict的代码
	 * 注意：dp[0] = 1
	 * @param : A string
	 * 
	 * @param : A set of word
	 * 
	 * @return: the number of possible sentences.
	 */
	public int wordBreak3(String s, Set<String> dict) {
		// Write your code here
		if (dict.size() == 0 || s.length() == 0)
			return 0;
		String[] aStrings = new String[] {};
		aStrings = dict.toArray(aStrings);
		for (String str : aStrings) {
			dict.add(str.toLowerCase());
		}
		s = s.toLowerCase();
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		for (int i = 1; i <= s.length(); i++) {
			int value = 0;
			for (int j = 1; j <= i; j++) {
				if (dict.contains(s.substring(j - 1, i)))
					value += dp[j - 1];
			}
			dp[i] = value;
		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		WordBreakIII test = new WordBreakIII();
		String[] arrays = new String[] { "Cat", "mat", "ca", "tm", "at", "C", "Dog", "og", "Do" };
		Set<String> dict = new HashSet<String>(Arrays.asList(arrays));
		System.out.println(test.wordBreak3("Catmat", dict));
		System.out.println();
	}

}

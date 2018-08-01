package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.Tool;

/**
 * Delete Operation for Two Strings
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * Example 1: Input: "sea", "eat" Output: 2 Explanation: You need one step to
 * make "sea" to "ea" and another step to make "eat" to "ea". 
 * 
 * Note: The length of given words won't exceed 500. Characters in given words can only be
 * lower-case letters.
 * 
 * beat 65%, 62ms
 * @author zhanghr
 *
 */
public class Code583 {
	public int minDistance(String word1, String word2) {
		int length1 =word1.length(), length2 = word2.length();
		int[][] equal = new int[length1][length2], matrix = new int[length1+1][length2+1];
		for (int i = 0; i < length1; i++) {
			char c = word1.charAt(i);
			for (int j = 0; j < length2; j++) {
				if (c == word2.charAt(j) ) {
					equal[i][j] = 1;
				}
			}
		}
		Tool.print(equal);
		
		for(int i = length1-1; i>=0;i--){
			for(int j = length2-1; j>=0;j--){
				matrix[i][j] =  Math.max( matrix[i+1][j], 
						Math.max(equal[i][j] + matrix[i+1][j+1], matrix[i][j+1]));
			}
		}
		Tool.print(matrix);
		
		int size = matrix[0][0];
		return length1-size+length2-size;
	}
	
	/**
	 * beat 35%, 70ms
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance1(String word1, String word2) {
		int length1 =word1.length(), length2 = word2.length();
		int[][] matrix = new int[length1+1][length2+1];		
		for(int i = length1-1; i>=0;i--){
			char c = word1.charAt(i);
			for(int j = length2-1; j>=0;j--){
				if (c == word2.charAt(j)) {
					matrix[i][j] = 1 + matrix[i+1][j+1];
				}else {
					matrix[i][j] =  Math.max( matrix[i+1][j], matrix[i][j+1]);
				}
			}
		}
		Tool.print(matrix);
		
		int size = matrix[0][0];
		return length1-size+length2-size;
	}
	
	public static void main(String[] args) {
		Code583 code583 = new Code583();
		String word1 = "sea", word2 = "eat";
		int result = code583.minDistance1(word1, word2), predict = 2;
		System.out.println(result + " "+ predict + " "+ (result == predict));
	}
	
	
}

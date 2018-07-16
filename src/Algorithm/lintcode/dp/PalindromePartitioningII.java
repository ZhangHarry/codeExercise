package Algorithm.lintcode.dp;

public class PalindromePartitioningII {
	/**
	 * beat 71.6%
	 * @param s: A string
	 * @return: An integer
	 */
	public int minCut(String s) {
		// write your code here
		if (s.length() <= 1)
			return 0;
		int length = s.length();
		int[] dp = new int[length + 1];
		char[] chars = s.toCharArray();
		for (int i = 2; i <= length; i++) {
			if (isPalindrome(chars, 0, i - 1))
				dp[i] = 0;
			else {
				int min = dp[i - 1] + 1;
				for (int start = 1; start < i; start++) {
					if (isPalindrome(chars, start, i - 1))
						min = Math.min(min, dp[start] + 1);
				}
				dp[i] = min;
			}
		}
		return dp[length];
	}

	public boolean isPalindrome(char[] chars, int start, int end) {
		while (start < end) {
			if (chars[start] != chars[end])
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioningII test = new PalindromePartitioningII();
		System.out.println(test.minCut("aab"));
	}
}

package Algorithm.lintcode.dp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * Example Given encoded message 12, it could be decoded as AB (1 2) or L (12).
 * The number of ways decoding 12 is 2.
 * 
 * @author zhanghr
 *
 */
public class DecodeWays {
	/**
	 * beat 65.4% 注意：'0'的情况
	 * 
	 * @param s:
	 *            a string, encoded message
	 * @return: an integer, the number of ways decoding
	 */
	public int numDecodings(String s) {
		// write your code here
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if (s.length() == 1)
			return 1;
		int[] dp = new int[s.length() + 1];
		char[] chars = s.toCharArray();
		dp[1] = 1;
		dp[0] = 1;
		for (int i = 2; i <= s.length(); i++) {
			if (chars[i - 1] != '0')
				dp[i] += dp[i - 1];
			if (isValid(chars[i - 2], chars[i - 1]))
				dp[i] += dp[i - 2];
		}
		return dp[s.length()];
	}

	private boolean isValid(char a, char b) {
		int v = (a - '0') * 10 + (b - '0');
		if (v >= 10 && v <= 26)
			return true;
		return false;
	}
}

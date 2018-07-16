package Algorithm.lintcode.dp;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example Given n = 12, return 3 because 12 = 4 + 4 + 4 Given n = 13, return 2
 * because 13 = 4 + 9
 * 
 * @author zhanghr
 *
 */
public class PerfectSquares {
	/**
	 * beat 76.8%
	 * 
	 * @param n:
	 *            a positive integer
	 * @return: An integer
	 */
	public int numSquares(int n) {
		// write your code here
		if (n <= 3)
			return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for (int i = 4; i <= n; i++) {
			int min = i;
			for (int j = 1; j * j <= i; j++) {
				min = Math.min(min, 1 + dp[i - j * j]);
			}
			dp[i] = min;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		PerfectSquares test = new PerfectSquares();
		System.out.println(test.numSquares(12));
	}

}

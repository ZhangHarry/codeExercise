package Algorithm.leetcode.finished;

import java.util.Arrays;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.classfile.Code;

import Algorithm.leetcode.util.Printer;


/**
 * 
 * @author zhanghr
 * 
 *         Given a positive integer n, find the least number of perfect square
 *         numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 *         For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n =
 *         13, return 2 because 13 = 4 + 9.
 */
public class Code279 {

	/**
	 * beat 50.50%
	 * 
	 * @param n
	 * @return
	 */
	public static int numSquares(int n) {
		int[] dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			dp[i] = i;
		}
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		Printer.print(dp);
		for (int i = 1; i <= n; i++) {
			for (int j = 0; i+ j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
			}
		}
		Printer.print(dp);
		return dp[n];
	}
	
	@Test
	public void test0(){
		Code279.numSquares(4);
	}

}

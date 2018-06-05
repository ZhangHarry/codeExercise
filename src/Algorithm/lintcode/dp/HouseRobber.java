package Algorithm.lintcode.dp;

/**
 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Example
 Given [3, 8, 4], return 8.

 * Created by zhanghr on 2018/6/3.
 */

public class HouseRobber {
    /**
     * beat 91.80%
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        int n= A.length;
        if (n==0)
            return 0;
        if (n == 1)
            return A[0];
        if (n == 2)
            return Math.max(A[0], A[1]);
        long[] dp = new long[n];
        dp[0] = A[0];
        dp[1] = A[1];
        dp[2] = A[0]+A[2];
        for (int i=3; i<n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3])+A[i];
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
}

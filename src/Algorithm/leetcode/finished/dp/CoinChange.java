package Algorithm.leetcode.finished.dp;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1

 * Created by zhanghr on 2018/6/27.
 */

public class CoinChange {
    // beat 31.41%
    public int coinChange(int[] coins, int amount) {
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        if (coins.length == 0)
            return -1;
        int[] dp = new int[amount+1];
        for (int i=1; i<=amount; i++){
            dp[i] = -1;
        }
        for (int i=0; i<coins.length; i++){
            for (int j=coins[i]; j<=amount; j++){
                if (dp[j] >= 0 && dp[j-coins[i]] >= 0)
                    dp[j] = Math.min(dp[j-coins[i]]+1, dp[j]);
                else if (dp[j-coins[i]] >= 0)
                    dp[j] = dp[j-coins[i]]+1;
            }
        }
        if (dp[amount] >= 0)
            return dp[amount];
        return -1;
    }
}

package Algorithm.lintcode.dp;

/**
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example
 Given coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Given coins = [2], amount = 3
 return -1.

 * Created by zhanghr on 2018/6/3.
 */

public class CoinChangeI {
    /**
     * beats 52.60%
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (amount < 0)
            return -1;
        if (amount==0)
            return 0;
        int[] dp = new int[amount+1];
        for (int i=1; i<= amount; i++){
            int min = amount+1;
            for (int j=0; j<coins.length; j++){
                if (i-coins[j]==0) {
                    min = 1;
                    break;
                }
                else if (i-coins[j]>0 && dp[i-coins[j]]>0)
                    min = Math.min(min, dp[i-coins[j]]+1);
            }
            dp[i] = min;
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }

    public static void main(String[] args){
        CoinChangeI test = new CoinChangeI();
        int[] coins = new int[]{0, 1,1,1, 8};
        System.out.println(test.coinChange(coins, 9));
    }
}

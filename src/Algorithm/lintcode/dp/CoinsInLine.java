package Algorithm.lintcode.dp;

/**
 * There are n coins in a line.
 * Two players take turns to take one or two coins from right side until there are no more coins left.
 * The player who take the last coin wins.
 * Could you please decide the first play will win or lose?
 *  beats 83.40%
 * Created by zhanghr on 2018/5/27.
 */

public class CoinsInLine {
    public boolean firstWillWin(int n) {
        // write your code here
        if (n <= 0)
            return false;
        boolean[] dp = new boolean[2];
        dp[0] = dp[1] = true;
        for (int i=2; i<n; i++){
            boolean tmp = dp[1];
            if (dp[0] && dp[1])
                dp[1] = false;
            else
                dp[1] = true;
            dp[0] = tmp;
        }
        return dp[1];
    }
}

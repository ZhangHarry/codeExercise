package Algorithm.lintcode.dp;

/**
 * There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left.
 * The player who take the coins with the most value wins.
 * Could you please decide the first player will win or lose?
 *
 * 我们是从后往前推，我们想如果是values数组的最后一位，及i = n-1时，此时dp[n-1]应该初始化为values[n-1]，因为拿了肯定比不拿大，钱又没有负面额；那么继续往前推，当i=n-2时，dp[n-2]应该初始化为values[n-2]+values[n-1]，应为最多可以拿两个，所以最大值肯定是两个都拿；当i=n-3时，dp[n-3]应该初始化为values[n-3]+values[n-2]，因为此时还剩三个硬币，你若只拿一个，那么就会给对手留两个，当然不行，所以自己要拿两个，只能给对手留一个，那么到目前位置初始化的步骤就完成了，下面就需要找递推式了：

 当我们处在i处时，我们有两种选择，拿一个还是拿两个硬币，我们现在分情况讨论：

 1. 当我们只拿一个硬币values[i]时，那么对手有两种选择，拿一个硬币values[i+1]，或者拿两个硬币values[i+1] + values[i+2]
 a) 当对手只拿一个硬币values[i+1]时，我们只能从i+2到end之间来取硬币，所以我们能拿到的最大硬币数为dp[i+2]
 b) 当对手拿两个硬币values[i+1] + values[i+2]时，我们只能从i+3到end之间来取硬币，所以我们能拿到的最大硬币数为dp[i+3]
 由于对手的目的是让我们拿较小的硬币，所以我们只能拿dp[i+2]和dp[i+3]中较小的一个，所以对于我们只拿一个硬币的情况，我们能拿到的最大钱数为values[i] + min(dp[i+2], dp[i+3])

 2. 当我们拿两个硬币values[i] + values[i + 1]时，那么对手有两种选择，拿一个硬币values[i+2]，或者拿两个硬币values[i+2] + values[i+3]
 a) 当对手只拿一个硬币values[i+2]时，我们只能从i+3到end之间来取硬币，所以我们能拿到的最大硬币数为dp[i+3]
 b) 当对手拿两个硬币values[i+2] + values[i+3]时，我们只能从i+4到end之间来取硬币，所以我们能拿到的最大硬币数为dp[i+4]
 由于对手的目的是让我们拿较小的硬币，所以我们只能拿dp[i+3]和dp[i+4]中较小的一个，所以对于我们只拿一个硬币的情况，我们能拿到的最大钱数为values[i] + values[i + 1] + min(dp[i+3], dp[i+4])

 综上所述，递推式就有了 dp[i] = max(values[i] + min(dp[i+2], dp[i+3]), values[i] + values[i + 1] + min(dp[i+3], dp[i+4]))


 * Created by zhanghr on 2018/5/27.
 */

public class CoinsInLineII {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values.length == 0)
            return false;
        if (values.length <= 2)
            return true;
        int length = values.length;
        int[] dp = new int[values.length]; // dp[i]表示第一个玩家位于第i个硬币时的最大值
        int sum = 0;
        sum += values[length-1]+values[length-2]+values[length-3];
        dp[length-1] = values[length-1];
        dp[length-2] = values[length-1]+values[length-2];
        dp[length-3] = values[length-2]+values[length-3];
        for (int i = length-4; i>=0; i--){
            dp[i] = Math.max(
                    Math.min(dp[i+2], dp[i+3])+values[i],
                    i+4 == length ? Integer.MIN_VALUE : Math.min(dp[i+3], dp[i+4])+values[i]+values[i+1]
            );
            sum+=values[i];
        }
        if (dp[0] > sum-dp[0])
            return true;
        return false;
    }

    public static void main(String[] args){
        CoinsInLineII test = new CoinsInLineII();
        System.out.println(test.firstWillWin(new int[]{1,2,4,8}));
    }
}

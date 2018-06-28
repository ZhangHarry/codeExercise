package Algorithm.leetcode.finished;

/**

 If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Note that you cannot sell a stock before you buy one.

 Example 1:

 Input: [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Not 7-1 = 6, as selling price needs to be larger than buying price.
 Example 2:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.

 * Created by zhanghr on 2018/6/17.
 */

public class BestTime2BuyAndSellStock {
    /**
     * beat 92.30%
     * 思路：遍历的过程中保留当前的最小值
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int profile = 0;
        int buy = prices[0];
        int sell = buy;
        for (int i=1; i<prices.length; i++){
            if (prices[i] >= sell)
                sell = prices[i];
            else {
                profile = Math.max(profile, sell-buy);
                sell = prices[i];
                if (buy > prices[i])
                    buy = prices[i];
            }
        }
        profile = Math.max(profile, sell-buy);
        return profile;
    }
}

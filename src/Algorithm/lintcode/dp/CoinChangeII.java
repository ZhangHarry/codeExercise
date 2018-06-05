package Algorithm.lintcode.dp;

/**
 You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 Example
 Given amount = 10, coins = [10], return 1

 Given amount = 8, coins = [2, 3, 8], return 3
 there are three ways to make up the amount:
 8 = 8
 8 = 3 + 3 + 2
 8 = 2 + 2 + 2 + 2

 * Created by zhanghr on 2018/6/3.
 */

public class CoinChangeII {
    /**
     * beat 95.96%
     * @param amount: a total amount of money amount
     * @param coins: the denomination of each coin
     * @return: the number of combinations that make up the amount
     */
    public int change(int amount, int[] coins) {
        // write your code here
        if (amount <=0)
            return 0;
        if (coins.length == 1)
            return amount%coins[0]==0 ? 1 :0;
        int[] layer1 = new int[amount+1], layer2 = new int[amount+1];
        for (int i=coins[0]; i<=amount;i+=coins[0]){
            layer1[i] = 1;
        }
        for (int i=1; i<coins.length; i++){
            for (int j=1; j<=amount; j++){
                layer2[j] = layer1[j]; // 不使用coins[j]的情况
                //使用coins[j]的情况
                if (j-coins[i] > 0)
                    layer2[j] += layer2[j-coins[i]];
                else if (j-coins[i] == 0) // 注意其实这种情况可以和>的情况合并：layer[0]=1即可
                    layer2[j] += 1;
            }
            layer1 = layer2;
        }
        return layer2[amount];
    }
}

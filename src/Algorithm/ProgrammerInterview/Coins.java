package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/20.
 题目描述
 有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。

 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。

 测试样例：
 6
 返回：2
 */

import java.util.*;

public class Coins {
    public int countWays(int n) {
        // write code here
        int[] dp =new int[n+1];
        dp[0] = 1;
        int[] coins = new int[]{25,10,5,1};
        for (int i =0; i<coins.length; i++){
            for (int j=1; j<=n; j++){
                if (j>=coins[i])
                    dp[j] = (dp[j]+dp[j-coins[i]])%1000000007;
            }
        }
        return dp[n];
    }
}
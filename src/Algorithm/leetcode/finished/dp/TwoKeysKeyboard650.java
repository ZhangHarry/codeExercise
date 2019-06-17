package Algorithm.leetcode.finished.dp;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/9/12.
 * Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

 Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 Paste: You can paste the characters which are copied last time.
 Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

 Example 1:
 Input: 3
 Output: 3
 Explanation:
 Intitally, we have one character 'A'.
 In step 1, we use Copy All operation.
 In step 2, we use Paste operation to get 'AA'.
 In step 3, we use Paste operation to get 'AAA'.
 Note:
 The n will be in the range [1, 1000].
 */

public class TwoKeysKeyboard650 {

    // beat 10%
    // 基本思路是遍历所有copy的情况，找出dp[n][n]的最佳情况。
    // 下面的解法做了很多无用功，可以优化：不需要二维数组，一维即可，因为dp[k][i]这些都可以算出来：dp[k][i]=dp[k][k]+i/k-1。所以44行这里的遍历也是不需要的，44行的遍历就是为了存储dp[k][i]
    public int minSteps(int n) {
        int[][] dp = new int[n+1][n+1]; // dp[2][4]表示copy=2，得到4需要的次数
        for (int[] a : dp)
            Arrays.fill(a, Integer.MAX_VALUE);
        dp[1][1] = 1;
        for (int i=2; i<=n;i++)
            dp[1][i] = dp[1][i-1]+1;
        for (int i=2; i<=n; i++){
            for (int k=1;k<i; k++){
                dp[i][i] = dp[k][i] == Integer.MAX_VALUE ?
                        dp[i][i] : Math.min(dp[i][i], dp[k][i]+1);
            }
            if (dp[i][i] < Integer.MAX_VALUE){
                int count = 1;
                for (int j=i<<1; j<=n; j+=i, count++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][i]+count);
                }
            }
        }

        if (dp[n][n] == Integer.MAX_VALUE)
            return 0;
        return dp[n][n]-1;
    }
}

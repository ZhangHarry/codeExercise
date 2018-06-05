package Algorithm.lintcode.dp;

/**
 Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

 Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
 Paste: You can paste the characters which are copied last time.
 Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.
 Example
 Input: 3
 Output: 3
 Explanation:
 Intitally, we have one character 'A'.
 In step 1, we use Copy All operation.
 In step 2, we use Paste operation to get 'AA'.
 In step 3, we use Paste operation to get 'AAA'.

 * Created by zhanghr on 2018/6/3.
 */

public class KeysKeyboard {
    /**
     * beat 28%
     * 思路：因为最终都是通过若干次paste得到的，paste来自于上一次已有的数据，所以n一定是paste的倍数
     * @param n: The number of 'A'
     * @return: the minimum number of steps to get n 'A'
     */
    public int minSteps(int n) {
        // Write your code here
        if (n<=0)
            return 0;
        if (n==1)
            return 0;
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i=2; i<=n;i++){
            int min = Integer.MAX_VALUE;
            for (int j=1; j<=i/2; j++){
                if (i%j==0){
                    min = Math.min(min, dp[j]+i/j);
                }
            }
            dp[i] = min;
        }

        return dp[n];
    }
}

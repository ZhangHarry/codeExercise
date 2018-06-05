package Algorithm.lintcode.dp;

/**
 *
 There is a fence with n posts, each post can be painted with one of the k colors.
 You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 Return the total number of ways you can paint the fence.

 Example
 Given n=3, k=2 return 6

 post 1,   post 2, post 3
 way1    0         0       1
 way2    0         1       0
 way3    0         1       1
 way4    1         0       0
 way5    1         0       1
 way6    1         1       0

 * Created by zhanghr on 2018/6/2.
 */

public class PaintFence {
    /**
     * beats 93.60%
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        if (n==1)
            return k;
        int[] dp = new int[n];
        dp[0] = k;
        dp[1] = k*k;
        for (int i=2; i<n;i++){
            dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1);
        }
        return dp[n-1];
    }
}

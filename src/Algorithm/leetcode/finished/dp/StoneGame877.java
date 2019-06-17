package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/9/13.
 * Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

 The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

 Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

 Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.



 Example 1:

 Input: [5,3,4,5]
 Output: true
 Explanation:
 Alex starts first, and can only take the first 5 or the last 5.
 Say he takes the first 5, so that the row becomes [3, 4, 5].
 If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
 If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
 This demonstrated that taking the first 5 was a winning move for Alex, so we return true.


 Note:

 2 <= piles.length <= 500
 piles.length is even.
 1 <= piles[i] <= 500
 sum(piles) is odd.
 */

public class StoneGame877 {
    public static void main(String[] args){
        int[] piles = new int[]{5,3,4,5};
        System.out.println(stoneGame(piles));
    }

    // beat 8%
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        if (n <= 1)
            return true;
        int[][] sum = new int[n][n];
        int tmp = 0;
        for (int i=0;i<n; i++){
            tmp += piles[i];
            sum[0][i] = tmp;
        }
        for (int i=1; i<n; i++){
            for (int j=i; j<n; j++)
                sum[i][j] = sum[0][j]-sum[0][i-1];
        }
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++)
            dp[i][i] = piles[i];
        for (int k=2; k<=n; k++){
            for (int i=0; k+i<=n; i++){
                int j = i+k-1;
                dp[i][j] = Math.max(sum[i+1][j]-dp[i+1][j]+piles[i], sum[i][j-1]-dp[i][j-1]+piles[j]);
            }
        }
        int res = dp[0][n-1];
        return res > sum[0][n-1]-res;
    }
}

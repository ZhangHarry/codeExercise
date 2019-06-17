package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/9/11.
 * We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */

public class GuessNumberHigherLowerII375 {

    public static void main(String []args) {
        System.out.println(getMoneyAmount(10));
    }

    // beat 20%
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int l=2; l<=n; l++){
            for (int i=1; i+l-1<=n; i++){
                int j = i+l-1;
                if (l==2){
                    dp[i][j] = i;
                }else{
                    int max = Integer.MAX_VALUE;
                    for (int k=i; k<=j; k++){
                        max = Math.min(Math.max(
                                k-1<=i ? k : k+dp[i][k-1],
                                k+1>=j ? k : k+dp[k+1][j]
                        ), max);
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[1][n];
    }

    public static int getMoneyAmount1(int n) {
        int[][] table1 = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table1[i][k-1], table1[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table1[i][j] = i+1==j?i:globalMin;
            }
        }
        return table1[1][n];
    }
}

package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/7/16.
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 Example:

 Input:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0

 Output: 4

 */

public class MaximalSquare {
    // 注意：是char[]不是int[]!!!
    // 思路：对于n*n的正方形，dp[i][j+1],dp[i+1][j],dp[i+1][j+1]应该至少是n-1*n-1的正方形
    // beat 98.80%
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0)
            return 0;

        int max = 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp= new int[rows][columns];
        for (int i=0;i<rows;i++){
            dp[i][columns-1] = matrix[i][columns-1]-'0';
            max = Math.max(max, dp[i][columns-1]);
        }
        for (int j=0; j<columns;j++){
            dp[rows-1][j] = matrix[rows-1][j]-'0';
            max = Math.max(max, dp[rows-1][j]);
        }
        for (int i=rows-2; i>=0; i--){
            for (int j=columns-2;j>=0;j--){
                if (matrix[i][j] == '1'){
                    int tmp = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1]);
                    dp[i][j] = tmp+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}

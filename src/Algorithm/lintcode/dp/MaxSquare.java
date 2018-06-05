package Algorithm.lintcode.dp;

/**
 *
 *Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

 Example
 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.

 * Created by zhanghr on 2018/6/1.
 */

public class MaxSquare {
    /**
     * 思路：对于n*n的正方形，dp[i][j+1],dp[i+1][j],dp[i+1][j+1]应该至少是n-1*n-1的正方形
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        int max = 0;
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp= new int[rows][columns];
        for (int i=0;i<rows;i++){
            dp[i][columns-1] = matrix[i][columns-1];
            max = Math.max(max, dp[i][columns-1]);
        }
        for (int j=0; j<columns;j++){
            dp[rows-1][j] = matrix[rows-1][j];
            max = Math.max(max, dp[rows-1][j]);
        }
        for (int i=rows-2; i>=0; i--){
            for (int j=columns-2;j>=0;j--){
                if (matrix[i][j] == 1){
                    int tmp = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i+1][j+1]);
                    dp[i][j] = tmp+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
    public static void main(String[] args){
        MaxSquare test = new MaxSquare();
        int[][] array = new int[][]{
                new int[]{0,1,1,1,1,1,1,1,1,1},
                new int[]{1,0,1,1,1,1,1,1,1,1},
                new int[]{1,1,0,1,1,1,1,1,1,1},
                new int[]{1,1,1,0,1,1,1,1,1,1},
                new int[]{1,1,1,1,0,1,1,1,1,1},
                new int[]{1,1,1,1,1,0,1,1,1,1},
                new int[]{1,1,1,1,1,1,0,1,1,1},
                new int[]{1,1,1,1,1,1,1,0,1,1},
                new int[]{1,1,1,1,1,1,1,1,0,1},
                new int[]{1,1,1,1,1,1,1,1,1,0}
        };
        System.out.println(test.maxSquare(array));
    }
}

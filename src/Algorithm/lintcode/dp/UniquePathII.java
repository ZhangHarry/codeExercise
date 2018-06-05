package Algorithm.lintcode.dp;

/**
 * beats 58.20%
 * Created by zhanghr on 2018/5/27.
 */

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[] dp = new int[columns];
        for (int i=0; i<columns; i++){
            if (obstacleGrid[0][i] == 1)
                dp[i] = 0;
            else
                dp[i] = i == 0 ? 1 : dp[i-1];
        }
        for (int i=1; i<rows; i++){
            for (int j=0;j<columns; j++){
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else
                    dp[j] = j==0 ? dp[j] : dp[j-1]+dp[j];
            }
        }
        return dp[columns-1];
    }

    public static void main(String[] args){
        UniquePathII test = new UniquePathII();
        test.uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0}
        });
    }
}

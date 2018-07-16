package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/7/12.
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Note: m and n will be at most 100.

 */

public class UniquePathsII {
    // beat 100%
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=0; i<m; i++){
            for (int j=0;j<n;j++){
                if (obstacleGrid[i][j] == 1)
                    dp[j+1] = 0;
                else
                    dp[j+1] += dp[j];
            }
        }
        return dp[n];
    }
}

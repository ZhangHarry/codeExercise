package Algorithm.lintcode.dp;

/**
 A robot is located at the top-right corner of a m x n grid.
 The robot can only move either down or left at any point in time. The robot is trying to reach the bottom-left corner of the grid.
 Every grid has a number,the robot wants to get the max weighted sum path.
 What is the maximum weighted sum path?

 Example
 Give
 [
 [1,2,3,4],
 [3,5,6,7],
 [9,10,1,2],
 [4,4,5,5]
 ]
 ,return 45.

 Explanation:
 The path is [4,7,6,5,10,9,4].
 Give
 [
 [1,2,3],
 [4,5,6],
 [7,9,8]
 ]
 ,return 33.

 Explanation:
 The path is [3,6,8,9,7].

 * Created by zhanghr on 2018/6/6.
 */

public class MaximumWeightedSumPath {
    /**
     * beat 90.2%
     * @param nums:
     * @return: nothing
     */
    public int maxWeight(int[][] nums) {
        if (nums.length == 0)
            return 0;
        int rows = nums.length, columns = nums[0].length;
        int[] dp = new int[columns];
        dp[columns-1] = nums[0][columns-1];
        for (int j=columns-2; j>=0;j--)
            dp[j] += nums[0][j]+dp[j+1];

        for (int i=1; i< rows; i++){
            dp[columns-1] = nums[i][columns-1] + dp[columns-1];
            for (int j=columns-2; j>=0;j--)
                dp[j] = nums[i][j] + Math.max(dp[j], dp[j+1]);
        }
        return dp[0];
    }
}

package Algorithm.leetcode.finished.dp;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/7/12.
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?
 */

public class UniquePaths {
    // beat 100%
    // dp[i,j] = dp[i-1,j]+dp[i,j-1]，优化合并成单维数组，所以0~m的循环先算dp[i-1,j]，0~n保留dp[i,j-1]
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=0; i<m; i++){
            for (int j=0;j<n;j++){
                dp[j+1] += dp[j];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args){
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(3, 2));
    }
}

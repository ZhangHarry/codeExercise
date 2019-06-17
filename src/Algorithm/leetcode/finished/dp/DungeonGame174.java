package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/8/30.

 The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 */

public class DungeonGame174 {
    // beat 93%
    // 重点在于dp应该从[n-1][n-1]开始，而不是从[0][0]开始，因为[n-1][n-1]的状态是已知的，不受其他状态影响，但是[0][0]会受到后面的影响。
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        if (rows==0)
            return 0;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        dp[rows-1][cols-1] = Math.max(1, 1-dungeon[rows-1][cols-1]);
        for (int i=cols-2; i>=0;i--){
            dp[rows-1][i] = Math.max(1, dp[rows-1][i+1]-dungeon[rows-1][i]);
        }
        for (int i=rows-2; i>=0; i--){
            dp[i][cols-1] = Math.max(1, dp[i+1][cols-1]-dungeon[i][cols-1]);
        }

        for (int i=rows-2; i>=0; i--){
            for (int j=cols-2; j>=0;j--){
                int right = Math.max(1, dp[i][j+1]-dungeon[i][j]);
                int down = Math.max(1, dp[i+1][j]-dungeon[i][j]);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }
}

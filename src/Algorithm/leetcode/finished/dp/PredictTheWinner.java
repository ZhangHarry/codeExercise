package Algorithm.leetcode.finished.dp;

/**
 Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

 Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

 Example 1:
 Input: [1, 5, 2]
 Output: False
 Explanation: Initially, player 1 can choose between 1 and 2.
 If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 Hence, player 1 will never be the winner and you need to return False.

 Note:
 1 <= length of the array <= 20.
 Any scores in the given array are non-negative integers and will not exceed 10,000,000.
 If the scores of both players are equal, then player 1 is still the winner.

 * Created by zhanghr on 2018/6/28.
 */

public class PredictTheWinner {
    int[][] dp;
    int[] sum;
    // beat 93.28%
    // dp[i][j] = max(sum[i,j]-dp[i+1][j]+nums[i], sum[i,j]-dp[i][j-1]+nums[j])
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length <= 1)
            return true;
        dp = new int[nums.length][nums.length];
        for (int i=0;i<nums.length; i++){
            for (int j=i; j< nums.length; j++)
                dp[i][j] = -1;
        }
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1; i<nums.length; i++)
            sum[i] = nums[i]+sum[i-1];
        int v1 = get(0, nums.length-1, nums);
        return v1 >= sum[nums.length-1]-v1;
    }

    public int get(int i, int j, int[] nums){
        if (i == nums.length)
            return nums[i-1];
        if (j < 0)
            return nums[0];
        if (dp[i][j] >= 0)
            return dp[i][j];
        dp[i][j] = sum[j]-sum[i]+nums[i] + Math.max(nums[i]-get(i+1, j, nums), nums[j]-get(i, j-1, nums));
        return dp[i][j];
    }

    public static void main(String[] args){
        PredictTheWinner test = new PredictTheWinner();
        int[] nums = new int[]{1,5,2};
        System.out.println(test.PredictTheWinner(nums));
    }
}

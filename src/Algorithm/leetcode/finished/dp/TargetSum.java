package Algorithm.leetcode.finished.dp;

/**
 * Created by zhanghr on 2018/7/18.

 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.
 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.

 */

public class TargetSum {
    int sol = 0;
    // beat 36.52%
    // dfs，更优的解法是转化成dp问题：因为P+N=sum, P-N=target，所以等价于从里面挑出若干个数之和等于(sum+target)/2
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0);
        return sol;
    }

    public void dfs(int[] nums, int S, int i) {
        if (i ==nums.length){
            if (S == 0)
                sol++;
            return;
        }
        dfs(nums, S+nums[i], i+1);
        dfs(nums, S-nums[i], i+1);
    }
}

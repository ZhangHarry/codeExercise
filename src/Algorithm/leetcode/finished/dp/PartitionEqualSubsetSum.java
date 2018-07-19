package Algorithm.leetcode.finished.dp;

import java.util.Arrays;

/**
 * Created by zhanghr on 2018/7/17.

 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.

 */

public class PartitionEqualSubsetSum {
    // beat 84.73%
    // 思路：背包问题，注意dp问题的子问题，第一次写错的原因：1、内循环写反，应该--，因为需要用到以前的值；2、dp的子问题只考虑到了选取当前item的情况
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int n:nums)
            target +=n;
        if (target % 2 != 0)
            return false;
        target = target/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i=0; i<nums.length;i++) {
            for (int j=target;j > 0; j--){
                if (j-nums[i]>=0)
                    dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args){
        PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
        int[] nums = new int[]{1,2,5};
        test.canPartition(nums);
    }
}

package Algorithm.lintcode.dp;

/**
 *
 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 Example
 nums = [3,6,4], return 6

 * Created by zhanghr on 2018/6/6.
 */

public class HouseRobberII {
    /**
     * beat 45.20%
     * @param nums: An array of non-negative integers.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums.length == 0)
            return 0;
        if (nums.length==1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        if (nums.length == 3)
            return  Math.max(Math.max(nums[0], nums[1]), nums[2]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = 0; // ensure select first item
        dp[2] = nums[0]+nums[2];
        for (int i=3; i<nums.length-1; i++){
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        int tmp = Math.max(dp[nums.length-2], dp[nums.length-3]);
        dp[0] = 0; // ensure select second item
        dp[1] = nums[1];
        dp[2] = nums[2];
        for (int i=3; i<nums.length; i++){
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        int tmp2 = Math.max(dp[nums.length-1], dp[nums.length-2]);
        return Math.max(tmp2, tmp);
    }
}

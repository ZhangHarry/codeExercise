package Algorithm.lintcode.dp;

/**
 * Given a set of positive integers, write a function to divide it into two sets
 * S1 and S2 such that the absolute difference between their sums is minimum.
 * 
 * If there is a set S with n elements, then if we assume Subset1 has m
 * elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) –
 * sum(Subset2)) should be minimum.
 * 
 * Example Given nums = [1, 6, 11, 5], return 1
 * 
 * // Subset1 = [1, 5, 6], sum of Subset1 = 12 // Subset2 = [11], sum of Subset2
 * = 11 // abs(11 - 12) = 1
 * 
 * Created by zhanghr on 2018/6/6.
 */

public class MinimumPartition {
	/**
	 * beat 95.77%
	 * 思路：其实就是01背包问题，一个item只能取一次，注意到背包问题中dp[item.length+1][value+1]中一次外循环，每个value只出现一次，item会出现多次（当前item会让每个value都试试）
	 * 而01背包问题要求item只能取一次，将上面的dp互换即可，dp[value+1][item.length+1]，一次外循环，item最多只能取一次。
	 * dp[j][i] = Math.max(dp[j-nums[i-1]][i-1]+nums[i-1], dp[j][i-1])
	 * 矩阵为（value+1）（item.length+1）
	 * 注意到dp[j][i]取决于dp[j][i-1]，所以可以按列（即先遍历dp[j][0-i]，再dp[j+1][0-i]），所以可以化简为value+1。
	 * 另外因为dp[j]依赖于上一轮的前面的元素，所以不能按0-j遍历（这样会修改dp的值为当前这轮），只能j-0地遍历
	 * 
	 * @param nums:
	 *            the given array
	 * @return: the minimum difference between their sums
	 */
	public int findMin(int[] nums) {
		// write your code here
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int sum = 0;
		for (int n : nums)
			sum += n;
		int target = sum / 2;
		int[] dp = new int[target + 1];
		for (int i = 1; i <= nums.length; i++) {
			for (int j = target; j >= 1; j--) {
				if (j - nums[i - 1] >= 0)
					dp[j] = Math.max(dp[j - nums[i - 1]] + nums[i - 1], dp[j]);
			}
		}
		return sum - (dp[target] << 1);
		// int[][] dp = new int[target+1][nums.length+1];
		// for (int j=1; j<= target; j++){
		// for (int i=1; i<= nums.length; i++){
		// if (j-nums[i-1]>=0)
		// dp[j][i] = Math.max(dp[j-nums[i-1]][i-1]+nums[i-1], dp[j][i-1]);
		// else
		// dp[j][i] = dp[j][i-1];
		// }
		// }
		//
		// return sum-(dp[target][nums.length]<<1);
	}

	public static void main(String[] args) {
		MinimumPartition test = new MinimumPartition();
		int[] nums = new int[] { 1, 21 };
		System.out.println(test.findMin(nums));
	}
}

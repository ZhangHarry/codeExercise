package Algorithm.lintcode;

/**
 * A sequence of numbers is called a wiggle sequence if the differences between
 * successive numbers strictly alternate between positive and negative. The
 * first difference (if one exists) may be either positive or negative. A
 * sequence with fewer than two elements is trivially a wiggle sequence.
 * 
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences
 * (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5]
 * and [1,7,4,5,5] are not wiggle sequences, the first because its first two
 * differences are positive and the second because its last difference is zero.
 * 
 * Given a sequence of integers, return the length of the longest subsequence
 * that is a wiggle sequence. A subsequence is obtained by deleting some number
 * of elements (eventually, also zero) from the original sequence, leaving the
 * remaining elements in their original order.
 * 
 * Example Input: [1,7,4,9,2,5] Output: 6 The entire sequence is a wiggle
 * sequence.
 * 
 * Input: [1,17,5,10,13,15,10,5,16,8] Output: 7 There are several subsequences
 * that achieve this length. One is [1,17,10,13,10,16,8].
 * 
 * Input: [1,2,3,4,5,6,7,8,9] Output: 2 Challenge Can you do it in O(n) time?
 * 
 * @author zhanghr
 *
 */

public class WiggleSubsequence {
	/**
	 * getLenth2()、getLenth3()是对getLenth()的简化
	 * 
	 * @param nums:
	 *            the given sequence
	 * @return: the length of the longest subsequence that is a wiggle sequence
	 */
	public int wiggleMaxLength(int[] nums) {
		// Write your code here
		if (nums.length <= 1)
			return nums.length;
		// return Math.max(getLength(nums, true), getLength(nums, false));
		return getLength3(nums);
	}

	public int getLength1(int[] nums, boolean up) {
		int length = 1, border = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (up) {
				if (nums[i] > border) {
					border = nums[i];
					length++;
					up = false;
				} else {
					border = nums[i];
				}
			} else {
				if (nums[i] < border) {
					border = nums[i];
					length++;
					up = true;
				} else {
					border = nums[i];
				}
			}
		}
		return length;
	}

	public int getLength2(int[] nums, boolean up) {
		int length = 1, border = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (up && nums[i] > border || !up && (nums[i] < border)) {
				length++;
				up = !up;
			}
			border = nums[i];
		}
		return length;
	}

	public int getLength3(int[] nums) {
		int lengthUp = 1, lengthDown = 1, border = nums[0];
		boolean up = true, down = true;
		for (int i = 1; i < nums.length; i++) {
			if ((up && nums[i] > border) || (!up && nums[i] < border)) {
				lengthUp++;
				up = !up;
			}
			if ((!down && nums[i] > border) || (down && nums[i] < border)) {
				lengthDown++;
				down = !down;
			}
			border = nums[i];
		}
		return lengthDown > lengthUp ? lengthDown : lengthUp;
	}

}

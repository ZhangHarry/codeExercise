package Algorithm.leetcode.finished;

/**
 * 
 * @author zhanghr
 *
 *         Given an array nums, write a function to move all 0's to the end of
 *         it while maintaining the relative order of the non-zero elements.
 * 
 *         For example, given nums = [0, 1, 0, 3, 12], after calling your
 *         function, nums should be [1, 3, 12, 0, 0].
 * 
 *         Note: You must do this in-place without making a copy of the array.
 *         Minimize the total number of operations.
 */
public class Code283 {
	/**
	 * beat 18.05%
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		int size = nums.length;
		int j=0;
		for (int i =0; i<size; i++){
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
		}
		for (; j < size; j++) {
			nums[j] = 0;
		}
	}

}

package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/16.

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 You may assume no duplicate exists in the array.

 Example 1:

 Input: [3,4,5,1,2]
 Output: 1
 Example 2:

 Input: [4,5,6,7,0,1,2]
 Output: 0

 */

public class FindMinimumInRotatedSortedArray {
    // beat 100%
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;
        while (start <= end){
            if (start >= end-1)
                return Math.min(nums[start], nums[end]);
            int mid = start + (end-start)/2;
            if (nums[start] < nums[end])
                return nums[start];
            else if (nums[mid] > nums[end]){
                start = mid;
            }else if (nums[mid] < nums[end]){
                end = mid;
            }
        }
        return 0;
    }
}

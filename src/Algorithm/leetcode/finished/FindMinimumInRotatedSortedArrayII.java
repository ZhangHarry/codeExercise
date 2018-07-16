package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/16.
 *
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

 Find the minimum element.

 The array may contain duplicates.

 Example 1:

 Input: [1,3,5]
 Output: 1
 Example 2:

 Input: [2,2,2,0,1]
 Output: 0

 */

public class FindMinimumInRotatedSortedArrayII {
    // beat 100%
    // 值得注意的地方：当nums[mid] = nums[end]时，我们不能确定缩减范围到左侧还是右侧，为了继续lgn的算法，将end--。
    // 这种最差的做法虽然不能保证最差lgn，但是保持了平均lgn，当我们没有办法继续处理时这种智慧值得借鉴
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
            }else { // 无法确定左侧还是右侧，end--
                end--;
            }
        }
        return 0;
    }
}

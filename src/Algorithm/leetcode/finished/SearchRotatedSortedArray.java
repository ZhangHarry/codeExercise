package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/16.

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1

 */

public class SearchRotatedSortedArray {
    // beat 100%
    // 注意正常的二叉搜索2种移动+非单调的二叉搜索2种移动，一共需要判断的4种情况
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while (start <= end){
            if (nums[start] == target)
                return start;
            if (nums[end] == target)
                return end;
            if (start == end)
                return -1;
            int mid = start+(end-start)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[start]< target && nums[mid] > target){ // 一般的二叉搜索情况
                end = mid-1;
            }else if (nums[mid] < target && nums[end] > target){// 一般的二叉搜索情况
                start = mid+1;
            }else if (nums[mid] > nums[end]){ // 中点落在左侧，start右移，在剩下的非单调区域继续找
                start = mid+1;
            }else if (nums[mid] < nums[start]){  // 中点落在右侧，end左移，在剩下的非单调区域继续找
                end = mid-1;
            }else
                return -1;
        }
        return -1;
    }
}

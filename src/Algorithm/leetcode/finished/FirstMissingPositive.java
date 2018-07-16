package Algorithm.leetcode.finished;

/**
 Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1

 * Created by zhanghr on 2018/7/8.
 */

public class FirstMissingPositive {
    // 99.51%
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i=0;
        while (i<n){
            if (nums[i] != i+1){
                if (nums[i]<=0 || nums[i]>n)
                    i++;
                else {
                    int index = nums[i];
                    if(nums[index-1] != index){
                        swap(nums, i, index-1);
                    }else
                        i++;
                }
            }else
                i++;
        }
        i=0;
        for (;i<n;i++){
            if (nums[i] != i+1)
                return i+1;
        }
        return n+1;
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}

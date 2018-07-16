package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/15.
 Given an array nums of n integers where n > 1,
 return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]
 Note: Please solve it without division and in O(n).

 Follow up:
 Could you solve it with constant space complexity?
 (The output array does not count as extra space for the purpose of space complexity analysis.)

 */

public class ProductOfArrayExceptSelf {
    // beat 100%
    // 思路：正常的做法是用两个数组维护左边的乘积和右边的乘积，观察可以发现这两个数组的元素都可以同上一个元素乘以nums元素得到
    //       实际上只维护最终数组即可，因为左侧数组和右侧数组相乘得到目标数组，它们可以合并到一个数组，只使用左侧数组
    //       又因为一个数组每个元素的值可以依赖前一个元素，所以右侧数组只需要保留一个元素即可。
    public int[] productExceptSelf(int[] nums) {
        int[] result= new int[nums.length];
        result[0] = 1;
        for (int i=1; i<nums.length; i++){
            result[i] = result[i-1]*nums[i-1];
        }
        int product = 1;
        for (int i=nums.length-1; i>=0; i--){
            result[i] *= product;
            product *= nums[i];
        }
        return result;
    }
}

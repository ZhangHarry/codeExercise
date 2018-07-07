package Algorithm.leetcode.finished;

import java.util.Arrays;

/**
 *
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 * Created by zhanghr on 2018/7/6.
 */

public class NextPermutation {
    int tmp;
    // beat 100%, 思路：先找到第一个nums[i]>nums[i-1]的地方，然后将nums[i]~末尾按从小到大排序（即翻转），最后从nums[i]~末尾这段找出第一个大于nums[i-1]的值与nums[i-1]交换
    // 可优化的地方：遍历查找可以变成binary查找
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int length = nums.length;
        boolean has = false;
        int i=length-1;
        for (; i>0;i--){
            if (nums[i] > nums[i-1]){
                has = true;
                break;
            }
        }

        if (!has){
            reverse(nums, 0, length-1);
        }else{
            if (i==length-1) {
                swap(nums, i-1, i);
                return;
            }
            reverse(nums, i, length-1);
            int j = i-1;
            int val = nums[j];
            while (i < length){
                if (nums[i] > val){
                    swap(nums, j, i);
                    break;
                }else
                    i++;
            }
        }
    }

    public void swap(int[] nums, int start, int end){
        tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        NextPermutation test = new NextPermutation();
        int[] nums = new int[]{2,3,1};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

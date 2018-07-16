package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.Printer;

/**
 * Created by zhanghr on 2018/7/12.

 Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:

 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Follow up:

 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with a one-pass algorithm using only constant space?

 */

public class SortColors {
    // beat 100%
    // 思路：类似于快排把数据分成三块，使用左右两个指针表示小于和大于的位置。
    // 这里需要注意的时等于的情况（nums[i]=1），这时我们跳过i，即不设置nums[i]为0或2，同时left指针不移动，使用flag标记这个事件。
    // 当下次遇到0时，0要排在1前面，这是left指针起作用，往前进一步。代码里还对right指针进行了优化，跳过为2的地方。
    public void sortColors(int[] nums) {
        int left =0, right = nums.length-1;
        boolean one = false;
        while (right>=0 && nums[right] == 2)
            right--;
        if (right<0)
            return;
        for (int i=0; i<=right; ){
            if (nums[i] == 0){
                if (!one){
                    left++;
                }else{
                    nums[left] = 0;
                    nums[i] = 1;
                    left++;
                }
                i++;
            }
            else if(nums[i] == 2){
                swap(nums, i, right);
                while (right>=0 && nums[right] == 2)
                    right--;
            }else{
                one=true;
                i++;
            }
        }
    }
    public void swap(int[] nums, int i,int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args){
        SortColors test = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        test.sortColors(nums);
    }
}

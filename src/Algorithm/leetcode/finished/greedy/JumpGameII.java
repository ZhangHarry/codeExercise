package Algorithm.leetcode.finished.greedy;

/**
 * Created by zhanghr on 2018/7/12.
 *
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 Example:

 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Note:

 You can assume that you can always reach the last index.
 *
 */

public class JumpGameII {
    //  beat 97.51%
    // 思路：从当前位置可以到达的所有位置中选择可以走得最远的那个作为接下来跳到的位置
    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int step = 0;
        int i=0;
        for (; i<nums.length;){
            int jump = nums[i];
            int next = i;
            for (int j=i+1; j<=i+jump; j++){
                if (j>=nums.length-1)
                    return step+1;
                // 选择可以走得最远的那项，并且步长不为0
                if (nums[j] >0 && j+nums[j] >= next+nums[next])
                    next = j;
            }
            step++;
            i = next;
        }

        return step;
    }
}

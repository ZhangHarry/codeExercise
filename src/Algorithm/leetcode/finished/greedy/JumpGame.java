package Algorithm.leetcode.finished.greedy;

/**
 * Created by zhanghr on 2018/7/12.
 *
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:

 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 Example 2:

 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.

 */

public class JumpGame {
    // beat 98.89%
    // 思路：从当前位置可以到达的所有位置中选择可以走得最远的那个作为接下来跳到的位置
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int i=0;
        for (; i<nums.length;){
            int jump = nums[i];
            int next = i;
            for (int j=i+1; j<=i+jump; j++){
                if (j>=nums.length-1)
                    return true;
                // 选择可以走得最远的那项，并且步长不为0
                if (nums[j] >0 && j+nums[j] >= next+nums[next])
                    next = j;
            }
            if (i==next)
                return false;
            i = next;
        }

        return true;
    }
}

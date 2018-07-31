package Algorithm.leetcode.finished.greedy;

/**
 * Created by zhanghr on 2018/7/31.
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

 Return 0 if the array contains less than 2 elements.

 Example 1:

 Input: [3,6,9,1]
 Output: 3
 Explanation: The sorted form of the array is [1,3,6,9], either
 (3,6) or (6,9) has the maximum difference 3.
 Example 2:

 Input: [10]
 Output: 0
 Explanation: The array contains less than 2 elements, therefore return 0.
 Note:

 You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 Try to solve it in linear time/space.
 */
import java.util.*;
public class MaximumGap {
    // beat 91%
    // 思路：正常来说要找出两个相邻数字的差，我们需要进行排序O(nlogn)，但是这里要求只需要O(n)。
    //          复杂度降低的原因是我们不需要知道每个元素的顺序，只需要找出最大间距。
    //          这里采用的思路与桶排序类似，把一些元素放在同一个桶里，然后保留每个桶的最小值和最大值，最大gap从相邻两个桶的min[i]-max[i-1]获取。
    //          因此我们需要保证桶里面的元素的gap不可能比桶之间的gap大---因为最大的gap一定比(所有元素的最大值-最小值)/元素个数大，所以把这个值作为桶的大小。
    public static int maximumGap(int[] nums) {
        if (nums.length<=1)
            return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num :nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (max == min)
            return 0;
        int interval = (max-min)/nums.length+1;
        int[] mins = new int[(max-min)/interval+1];
        int[] maxs = new int[(max-min)/interval+1];
        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);
        for(int num : nums){
            int slot = (num-min)/interval;
            mins[slot] = Math.min(num, mins[slot]);
            maxs[slot] = Math.max(num, maxs[slot]);
        }
        int res = 0;
        max = mins[0];
        for (int i=0; i<mins.length; i++){
            if (mins[i] <= maxs[i]){
                res = Math.max(res, mins[i]-max);
                max = maxs[i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,6,9,1};
        System.out.println(MaximumGap.maximumGap(nums));
    }
}

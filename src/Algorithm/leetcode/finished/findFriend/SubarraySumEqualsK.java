package Algorithm.leetcode.finished.findFriend;

/**
 * Created by zhanghr on 2018/7/19.
 *
 Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
import java.util.*;
public class SubarraySumEqualsK {
    // beat 33%
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();// key表示某个[0,index]连续数组之和需要的另一半[0,index']，value表示目前有多少个index需要key，当我们发现有个index'数组和等于key时，表示它可以与value个index搭配得到value个[index+1, index']连续数组之和为k。
        int sum = 0;
        int count = 0;
        map.put(k, 1); // 注意起始的一项，表示找到[0,index]的和就是k
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            int key = sum+k;
            count += map.getOrDefault(sum,0);
            map.put(key, map.getOrDefault(key, 0)+1); // 注意：put需要在get后面，否则可能key=sum时，多了1
        }

        return count;
    }

    public static void main(String[] args){
        SubarraySumEqualsK test = new SubarraySumEqualsK();
        int[] nums = new int[]{1};
        int k = 0;
        System.out.println(test.subarraySum(nums, k));
    }

}

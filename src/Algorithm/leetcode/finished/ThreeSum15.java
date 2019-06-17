package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/9/6.
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
import java.util.*;
public class ThreeSum15 {
    public static void main(String[] args){
        ThreeSum15 test = new ThreeSum15();
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(test.threeSum(nums));
    }

    // beat 60%
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length<3)
            return res;
        for (int i=1; i<nums.length-1; ){
            add(nums, i, nums.length-1, -1*nums[i-1], res);
            while (i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
            i++;
        }
        return res;
    }

    public void add(int[] nums, int s,int e, int t, List<List<Integer>> res){
        while (s < e) {
            if (nums[s] + nums[e] == t) {
                List<Integer> list = new ArrayList<>();
                list.add(-1 * t);
                list.add(nums[s]);
                list.add(nums[e]);
                res.add(list);
                s++;
                e--;
                while (s < e && nums[s] == nums[s - 1])
                    s++;
                while (s < e && nums[e] == nums[e + 1])
                    e--;
            } else if (nums[s] + nums[e] > t)
                e--;
            else
                s++;
        }
    }
}

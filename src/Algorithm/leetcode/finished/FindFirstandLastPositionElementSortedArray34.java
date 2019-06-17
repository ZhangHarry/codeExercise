package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/9/6.
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */

public class FindFirstandLastPositionElementSortedArray34 {
    // beat 50%
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0]=res[1]=-1;
        if (nums.length==0){
            return res;
        }
        int s =0, e=nums.length-1;
        while(s<e){
            if (nums[s]>target || nums[e]<target){
                res[0]=res[1]=-1;
                return res;
            }
            if (nums[s]<target && nums[e]>target){
                if (s==e-1){
                    res[0]=res[1]=-1;
                    return res;
                }
                int mid = s+(e-s)/2;
                if (nums[mid]<target)
                    s=mid;
                else
                    e=mid;
            }else if (nums[s] == target){
                res[0]=res[1]=s;
                s++;
                while (s<=e && nums[s]==target){
                    res[1]=s;
                    s++;
                }
                s=res[0];
                s--;
                while (s>=0 && nums[s]==target){
                    res[0]=s;
                    s--;
                }
                return res;
            }else{
                res[0]=res[1]=e;
                e--;
                while (s<=e && nums[e]==target){
                    res[0]=e;
                    e--;
                }
                e=res[1];
                e++;
                while (e<nums.length && nums[e]==target){
                    res[1] =e;
                    e++;
                }
                return res;
            }
        }
        if (s==e && nums[s]==target){
            res[0]=res[1]=s;
        }
        return res;
    }

    public static void main(String[] args){
        FindFirstandLastPositionElementSortedArray34 test = new FindFirstandLastPositionElementSortedArray34();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(test.searchRange(nums,target));
    }
}
